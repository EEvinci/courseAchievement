package com.evinci.courseAchievement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.entity.LikeRecordEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.repository.LikeRecordEntityRepository;
import com.evinci.courseAchievement.service.LikeRecordService;

@Service
public class LikeRecordServiceImpl implements LikeRecordService {
    @Autowired
    private CacheRedisServiceImpl cacheRedisService;
    @Autowired
    private LikeRecordEntityRepository likeRecordEntityRepository;


    @Override
    public int addOneRecordLikeHistory(LikeRecordEntity likeRecordEntity) throws ResourceNotFoundException {
        return 0;
    }
}
