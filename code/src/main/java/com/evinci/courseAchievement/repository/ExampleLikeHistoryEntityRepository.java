package com.evinci.courseAchievement.repository;

import com.evinci.courseAchievement.entity.ExampleLikeHistoryEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExampleLikeHistoryEntityRepository extends JpaRepository<ExampleLikeHistoryEntity, Integer> {
    @Query("select e.id from ExampleLikeHistoryEntity e where e.exampleIid = :exampleIid and e.userIid = :userIid")
    Integer findByExampleIidAndUserIid(@Param("exampleIid") Integer exampleIid, @Param("userIid") Integer userIid);
}