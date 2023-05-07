package com.example.testjpa.controller;

import com.example.testjpa.entity.KnowledgeReadHistoryEntity;
import com.example.testjpa.repository.KnowledgeReadHistoryEntityRepository;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.KnowledgeReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("read")
public class KnowledgeReadHistoryController {
    @Autowired
    private KnowledgeReadHistoryService knowledgeReadHistoryService;

    @PostMapping("/count")
    public ResponseData getCountOfReadHistory(@RequestBody KnowledgeReadHistoryEntity knowledgeReadHistoryEntity) {

        Integer count = knowledgeReadHistoryService.getCountOfReadHistory(knowledgeReadHistoryEntity.getKnowledgeIid());
        if (count >= 0) {
            return new ResponseData(ResponseMsg.SUCCESS, count);
        } else {
            return new ResponseData(ResponseMsg.FAILED, count);
        }
    }

    // {
    // "knowledgeIid":3,
    // "pageNum":0,
    // "pageSize":1
    // }
    @PostMapping("/query")
    public ResponseData findReadHistoryByKnowledgeIid(@RequestBody Map temp) {
        Page<KnowledgeReadHistoryEntity> knowledgeReadHistoryEntityPage = knowledgeReadHistoryService
                .findByKnowledgeIid((Integer) temp.get("knowledgeIid"), (Integer) temp.get("pageNum"),
                        (Integer) temp.get("pageSize"));
        // 缺少一个错误处理
        return new ResponseData(ResponseMsg.SUCCESS, knowledgeReadHistoryEntityPage);
    }

    @PostMapping("/add")
    public ResponseData addOneRecord(@RequestBody KnowledgeReadHistoryEntity knowledgeReadHistoryEntity) {
        int flag = knowledgeReadHistoryService.addOneRecord(knowledgeReadHistoryEntity);
        if (flag > 0) {
            return new ResponseData(ResponseMsg.SUCCESS, flag);
        } else {
            return new ResponseData(ResponseMsg.FAILED, flag);
        }
    }

    @PostMapping("query_max")
    public ResponseData queryMax20Example() {
        List<String> temp = knowledgeReadHistoryService.getTopScoringKnowledge("read_count_knowledge");
        if (temp.size() > 0) {
            return new ResponseData(ResponseMsg.SUCCESS, temp);
        } else {
            return new ResponseData(ResponseMsg.FAILED, temp);
        }

    }

}
