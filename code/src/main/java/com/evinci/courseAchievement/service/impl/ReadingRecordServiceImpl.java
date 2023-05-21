package com.evinci.courseAchievement.service.impl;

import com.evinci.courseAchievement.entity.ReadingRecordEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.repository.ReadingRecordEntityRepository;
import com.evinci.courseAchievement.service.ReadingRecordService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ReadingRecordServiceImpl implements ReadingRecordService {

    @Autowired
    private ReadingRecordEntityRepository readingRecordEntityRepository;

    @Autowired
    private CacheRedisServiceImpl cacheRedisService;

    @Override
    public Integer addOneRecord(ReadingRecordEntity readingRecordEntity) throws ResourceNotFoundException {
        return null;
    }

    // 获取数量


}
