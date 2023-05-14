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
    List<LabelGroupEntity> findByLabelGroupNumStringLike(String labelGroupNumString);

    // 根据标签组内容查询
    List<LabelGroupEntity> findByLabelGroupContentStringLike(String labelGroupContentsString);

    // 根据标签组编号删除
    void deleteById(String labelGroupNum);
}
