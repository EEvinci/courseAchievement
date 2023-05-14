package com.evinci.courseAchievement.controller;

import com.evinci.courseAchievement.entity.ExampleLikeHistoryEntity;
import com.evinci.courseAchievement.response.ResponseData;
import com.evinci.courseAchievement.response.ResponseMsg;
import com.evinci.courseAchievement.service.ExampleLikeHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/like")
public class ExampleLikeHistoryController {
    @Autowired
    private ExampleLikeHistoryService exampleLikeHistoryService;

    /**
     * 获取案例点赞总数的接口
     * @param exampleLikeHistoryEntity
     * @return
     */
    @PostMapping("/query")
    public ResponseData findCountOfLike(@RequestBody ExampleLikeHistoryEntity exampleLikeHistoryEntity) {
        int count = exampleLikeHistoryService.getCountOfExampleLike(exampleLikeHistoryEntity.getExampleId());
        if (count > 0) {
            return ResponseData.of(ResponseMsg.SUCCESS, count);
        } else {
            return ResponseData.of(ResponseMsg.FAILED, count);
        }

    }

    // 增加一条点赞记录
    @PostMapping("/add")
    public ResponseData addOneRecord(@RequestBody ExampleLikeHistoryEntity exampleLikeHistoryEntity) {
        int flag = exampleLikeHistoryService.addOneRecordLikeHistory(exampleLikeHistoryEntity);
        if (flag == 1) {
            return ResponseData.of(ResponseMsg.SUCCESS, flag);
        } else {
            return ResponseData.of(ResponseMsg.FAILED, flag);
        }
    }

    // 最高的20条记录
    @PostMapping("query_max")
    public ResponseData queryMax20Example() {
        List<String> temp = exampleLikeHistoryService.getTopScoringExample("like_count_example");
        if (temp.size() > 0) {
            return ResponseData.of(ResponseMsg.SUCCESS, temp);
        } else {
            return ResponseData.of(ResponseMsg.FAILED, temp);
        }

    }

}
