package com.example.testjpa.service;

import com.example.testjpa.entity.KnowledgeReadHistoryEntity;
import com.example.testjpa.exception.EchoServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KnowledgeReadHistoryService {
    // 获取知识点总数的接口
    Integer getCountOfReadHistory(Integer knowledgeIid) throws EchoServiceException;

    // 分页查询
    Page<KnowledgeReadHistoryEntity> findByKnowledgeIid(Integer knowledgeIid, int pageNum, int pageSize)
            throws EchoServiceException;

    public Integer addOneRecord(KnowledgeReadHistoryEntity knowledgeReadHistoryEntity) throws EchoServiceException;

    public List<String> getTopScoringKnowledge(String key) throws EchoServiceException;
}
