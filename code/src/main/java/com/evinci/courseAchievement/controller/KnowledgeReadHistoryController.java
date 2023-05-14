package com.evinci.courseAchievement.controller;

import com.evinci.courseAchievement.entity.KnowledgeReadHistoryEntity;
import com.evinci.courseAchievement.response.ResponseData;
import com.evinci.courseAchievement.response.ResponseMsg;
import com.evinci.courseAchievement.service.KnowledgeReadHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/read")
public class KnowledgeReadHistoryController {
    // 创建一个服务对象
    @Autowired
    private KnowledgeReadHistoryService knowledgeReadHistoryService;

    /*
     * 获取知识点总数的接口
     */
    @PostMapping("/count")
    public ResponseData getCountOfReadHistory(@RequestBody KnowledgeReadHistoryEntity knowledgeReadHistoryEntity) {

        Integer count = knowledgeReadHistoryService.getCountOfReadHistory(knowledgeReadHistoryEntity.getKnowledgeId());
        if (count >= 0) {
            return ResponseData.of(ResponseMsg.SUCCESS, count);
        } else {
            return ResponseData.of(ResponseMsg.FAILED, count);
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
                .findByKnowledgeId((Integer) temp.get("knowledgeId"), (Integer) temp.get("pageNum"),
                        (Integer) temp.get("pageSize"));
        // 缺少一个错误处理
        return ResponseData.of(ResponseMsg.SUCCESS, knowledgeReadHistoryEntityPage);
    }

    /*
     * 增加一条阅读记录
     */
    @PostMapping("/add")
    public ResponseData addOneRecord(@RequestBody KnowledgeReadHistoryEntity knowledgeReadHistoryEntity) {
        int flag = knowledgeReadHistoryService.addOneRecord(knowledgeReadHistoryEntity);
        if (flag > 0) {
            return ResponseData.of(ResponseMsg.SUCCESS, flag);
        } else {
            return ResponseData.of(ResponseMsg.FAILED, flag);
        }
    }

    /*
     * 返回排名最高的 20 条知识点
     */
    @PostMapping("/query_max")
    public ResponseData queryMax20Example() {
        List<String> temp = knowledgeReadHistoryService.getTopScoringKnowledge("read_count_knowledge");
        if (temp.size() > 0) {
            return ResponseData.of(ResponseMsg.SUCCESS, temp);
        } else {
            return ResponseData.of(ResponseMsg.FAILED, temp);
        }

    }

}
