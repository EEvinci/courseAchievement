package com.evinci.courseAchievement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.entity.LikeRecordEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.repository.ExampleLikeHistoryEntityRepository;
import com.evinci.courseAchievement.service.ExampleLikeHistoryService;

import java.sql.Timestamp;
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
    public int getCountOfExampleLike(Integer exampleIid) throws ResourceNotFoundException {
        // 采取使用 redis
        return cacheRedisService.getCountOfExampleLike(exampleIid);

    }

    @Override
    public int addOneRecordLikeHistory(LikeRecordEntity likeRecordEntity) throws ResourceNotFoundException {
        if (likeRecordEntity.getId() != 0) {
            throw new ResourceNotFoundException("在增加点赞记录，Id 应该为 0");
        }
        int Id = 0;
        int flagCache = 1;
        if (exampleLikeHistoryEntityRepository.findByExampleIidAndUserIid(likeRecordEntity.getExampleId(),
                likeRecordEntity.getId()) != null) {
            Id = exampleLikeHistoryEntityRepository.findByExampleIidAndUserIid(
                    likeRecordEntity.getExampleId(), likeRecordEntity.getId());
            // 原先已经点过赞，就不增加了
            System.out.println("该用户已经点过赞了");
            flagCache = 0;
        }
        try {
            System.out.println(Id);
            likeRecordEntity.setId(Id);
            TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
            Calendar calendar = Calendar.getInstance(timeZone);
            Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
            likeRecordEntity.setLikeTimestamp(timestamp);
            exampleLikeHistoryEntityRepository.save(likeRecordEntity);

            if (flagCache == 1) {
                cacheRedisService.addOneRecordExample(likeRecordEntity.getExampleId());
            }

        } catch (Exception e) {
            throw new ResourceNotFoundException("添加点赞的时候出错");
        }

        return 1;
    }

    @Override
    public List<String> getTopScoringExample(String key) throws ResourceNotFoundException {
        return cacheRedisService.getTopScoringElements(key, 20);
    }
}
