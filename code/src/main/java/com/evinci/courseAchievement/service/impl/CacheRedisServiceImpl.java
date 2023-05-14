package com.evinci.courseAchievement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CacheRedisServiceImpl {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String READ_COUNT_PREFIX = "read_count_knowledge";
    private static final String LIKE_COUNT_PREFIX = "like_count_example";

    public Integer getCountOfExampleLike(Integer exampleIid) {
        String key = LIKE_COUNT_PREFIX + "_" + exampleIid;
        String value = redisTemplate.opsForValue().get(key);

        return Integer.parseInt(value);
    }

    // example ++
    public Integer addOneRecordExample(Integer exampleIid) {

        String key = LIKE_COUNT_PREFIX;
        String member = "example_" + exampleIid;
        redisTemplate.opsForZSet().incrementScore(key, member, 1);

        return 1;
    }

    // knowledge ++
    public Integer addOneRecordKnowledge(Integer knowledgeIid) {
        String key = READ_COUNT_PREFIX;
        String member = "knowledge_" + knowledgeIid;
        redisTemplate.opsForZSet().incrementScore(key, member, 1);
        return 1;
    }

    public List<String> getTopScoringElements(String key, int count) {
        Set<String> elements = redisTemplate.opsForZSet().reverseRange(key, 0, count - 1);
        return new ArrayList<>(elements);
    }

}
