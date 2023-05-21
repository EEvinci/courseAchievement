package com.evinci.courseAchievement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evinci.courseAchievement.entity.ExampleEntity;

/**
 * @author evinci
 * @version 1.0
 */

public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Integer> {
    // 根据案例编号查询
    ExampleEntity findByExampleNum(String exampleNum);
}
