package com.evinci.courseAchievement.repository;

import com.evinci.courseAchievement.entity.LikeRecordEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikeRecordEntityRepository extends JpaRepository<LikeRecordEntity, Integer> {
    @Query("select e.id from LikeRecordEntity e where e.exampleId = :exampleId and e.userId = :userId")
    Integer findByExampleIdAndUserId(@Param("exampleId") Integer exampleId, @Param("userId") Integer userId);
}