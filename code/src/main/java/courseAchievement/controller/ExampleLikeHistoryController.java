package courseAchievement.controller;

import courseAchievement.entity.ExampleLikeHistoryEntity;
import courseAchievement.result.ResponseData;
import courseAchievement.result.ResponseMsg;
import courseAchievement.service.ExampleLikeHistoryService;

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
            return new ResponseData(ResponseMsg.SUCCESS, count);
        } else {
            return new ResponseData(ResponseMsg.FAILED, count);
        }

    }

    // 增加一条点赞记录
    @PostMapping("/add")
    public ResponseData addOneRecord(@RequestBody ExampleLikeHistoryEntity exampleLikeHistoryEntity) {
        int flag = exampleLikeHistoryService.addOneRecordLikeHistory(exampleLikeHistoryEntity);
        if (flag == 1) {
            return new ResponseData(ResponseMsg.SUCCESS, flag);
        } else {
            return new ResponseData(ResponseMsg.FAILED, flag);
        }
    }

    // 最高的20条记录
    @PostMapping("query_max")
    public ResponseData queryMax20Example() {
        List<String> temp = exampleLikeHistoryService.getTopScoringExample("like_count_example");
        if (temp.size() > 0) {
            return new ResponseData(ResponseMsg.SUCCESS, temp);
        } else {
            return new ResponseData(ResponseMsg.FAILED, temp);
        }

    }

}
