package com.example.testjpa.service;

import com.example.testjpa.entity.ExampleLikeHistoryEntity;
import com.example.testjpa.entity.KnowledgeReadHistoryEntity;
import com.example.testjpa.exception.EchoServiceException;

import java.util.List;

public interface ExampleLikeHistoryService {
    // 查找特定 example 的 阅读数量,
    public int getCountOfExampleLike(Integer exampleIid) throws EchoServiceException;


//    public  addOneRecordLikeHistory()
    public int addOneRecordLikeHistory(ExampleLikeHistoryEntity exampleLikeHistoryEntity) throws EchoServiceException;


    // 返回排名最高的 20 条案例
    public List<String> getTopScoringExample(String key) throws  EchoServiceException;
}
