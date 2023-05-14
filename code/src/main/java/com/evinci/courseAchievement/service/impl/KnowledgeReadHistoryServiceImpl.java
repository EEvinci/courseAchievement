package com.evinci.courseAchievement.service.impl;

import com.evinci.courseAchievement.entity.KnowledgeReadHistoryEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.repository.KnowledgeReadHistoryEntityRepository;
import com.evinci.courseAchievement.service.KnowledgeReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
public class KnowledgeReadHistoryServiceImpl implements KnowledgeReadHistoryService {

    @Autowired
    private KnowledgeReadHistoryEntityRepository knowledgeReadHistoryEntityRepository;

    @Autowired
    private CacheRedisServiceImpl cacheRedisService;

    // 获取数量
    @Override
    public Integer getCountOfReadHistory(Integer knowledgeIid) throws ResourceNotFoundException {
        if (knowledgeIid == 0) {
            throw new ResourceNotFoundException("knowledgeIid 不能为 0");
        }

        return knowledgeReadHistoryEntityRepository.countByKnowledgeIid(knowledgeIid);
    }

    @Override
    public Page<KnowledgeReadHistoryEntity> findByKnowledgeIid(Integer knowledgeIid, int pageNum, int pageSize)
            throws ResourceNotFoundException {
        // 也可以把sort写上
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return knowledgeReadHistoryEntityRepository.findByKnowledgeIid(knowledgeIid, pageable);
    }

    @Override
    public Integer addOneRecord(KnowledgeReadHistoryEntity knowledgeReadHistoryEntity) throws ResourceNotFoundException {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        Calendar calendar = Calendar.getInstance(timeZone);
        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        // FIXME: still bug
//        knowledgeReadHistoryEntity.getBuilder().setReadTimestamp(timestamp);
        try {
            // 由于knowledge 只需要++即可，不需要判断是否先前已经存在
            cacheRedisService.addOneRecordKnowledge(knowledgeReadHistoryEntity.getKnowledgeId());
            knowledgeReadHistoryEntityRepository.save(knowledgeReadHistoryEntity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("阅读记录添加时出错");
        }

        return 1;
    }

    @Override
    public List<String> getTopScoringKnowledge(String key) throws ResourceNotFoundException {
        return cacheRedisService.getTopScoringElements(key, 20);
    }

}
