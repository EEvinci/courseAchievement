package courseAchievement.service;

import java.util.List;
import courseAchievement.entity.ExampleLikeHistoryEntity;
import courseAchievement.exception.ResourceNotFoundException;

public interface ExampleLikeHistoryService {
    // 查找特定 example 的 阅读数量,
    public int getCountOfExampleLike(Integer exampleIid) throws ResourceNotFoundException;

    // public addOneRecordLikeHistory()
    public int addOneRecordLikeHistory(ExampleLikeHistoryEntity exampleLikeHistoryEntity) throws ResourceNotFoundException;

    // 返回排名最高的 20 条案例
    public List<String> getTopScoringExample(String key) throws ResourceNotFoundException;
}
