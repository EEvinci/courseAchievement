package com.evinci.courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evinci.courseAchievement.entity.LabelGroupEntity;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface LabelGroupEntityRepository extends JpaRepository<LabelGroupEntity, Integer> {
    // 根据标签组编号查询
    LabelGroupEntity findByLabelGroupNum(String labelGroupNum);


}
