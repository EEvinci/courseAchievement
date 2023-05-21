package com.evinci.courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evinci.courseAchievement.entity.LabelEntity;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface LabelEntityRepository extends JpaRepository<LabelEntity, Integer> {
    // 根据标签编号查询
    LabelEntity findByLabelNum(String labelNum);

}
