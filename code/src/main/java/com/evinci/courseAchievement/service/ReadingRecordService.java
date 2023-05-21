package com.evinci.courseAchievement.service;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.entity.ReadingRecordEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReadingRecordService {

    // 添加一条记录
    public Integer addOneRecord(ReadingRecordEntity readingRecordEntity) throws ResourceNotFoundException;

//    // 获取知识点总数的接口
//    Integer getCountOfReadHistory(Integer knowledgeIid) throws ResourceNotFoundException;
//
//    // 分页查询
//    Page<ReadingRecordEntity> findByKnowledgeId(Integer knowledgeIid, int pageNum, int pageSize)
//            throws ResourceNotFoundException;
//
//    // 返回排名最高的 20 条知识点
//    public List<String> getTopScoringKnowledge(String key) throws ResourceNotFoundException;
}
