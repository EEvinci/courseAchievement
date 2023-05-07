package com.example.testjpa.service.impl;

import com.example.testjpa.entity.ExampleLikeHistoryEntity;
import com.example.testjpa.exception.EchoServiceException;
import com.example.testjpa.repository.ExampleLikeHistoryEntityRepository;
import com.example.testjpa.service.ExampleLikeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
public class ExampleLikeHistoryServiceImpl implements ExampleLikeHistoryService {
    @Autowired
    private CacheRedisServiceImpl cacheRedisService;
    @Autowired
    private ExampleLikeHistoryEntityRepository exampleLikeHistoryEntityRepository;

    @Override
    public int getCountOfExampleLike(Integer exampleIid) throws EchoServiceException {
        // 采取使用 redis
        return cacheRedisService.getCountOfExampleLike(exampleIid);

    }

    @Override
    public int addOneRecordLikeHistory(ExampleLikeHistoryEntity exampleLikeHistoryEntity) throws EchoServiceException {
        if (exampleLikeHistoryEntity.getIid() != 0) {
            throw new EchoServiceException("在增加点赞记录，Iid 应该为 0");
        }
        int Iid = 0;
        int flagCache = 1;
        if (exampleLikeHistoryEntityRepository.findByExampleIidAndUserIid(exampleLikeHistoryEntity.getExampleIid(),
                exampleLikeHistoryEntity.getUserIid()) != null) {
            Iid = exampleLikeHistoryEntityRepository.findByExampleIidAndUserIid(
                    exampleLikeHistoryEntity.getExampleIid(), exampleLikeHistoryEntity.getUserIid());
            // 原先已经点过赞，就不增加了
            System.out.println("该用户已经点过赞了");
            flagCache = 0;
        }
        try {

            System.out.println(Iid);
            exampleLikeHistoryEntity.setIid(Iid);
            TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
            Calendar calendar = Calendar.getInstance(timeZone);
            Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
            exampleLikeHistoryEntity.setLikeTime(timestamp);
            exampleLikeHistoryEntityRepository.save(exampleLikeHistoryEntity);

            if (flagCache == 1) {
                cacheRedisService.addOneRecordExample(exampleLikeHistoryEntity.getExampleIid());
            }

        } catch (Exception e) {
            throw new EchoServiceException("添加点赞的时候出错");
        }

        return 1;
    }

    @Override
    public List<String> getTopScoringExample(String key) throws EchoServiceException {
        return cacheRedisService.getTopScoringElements(key, 20);
    }
}
