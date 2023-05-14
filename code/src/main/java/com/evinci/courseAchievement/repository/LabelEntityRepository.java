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
    List<LabelEntity> findByLabelNumStringLike(String labelNumString);

    // 根据标签内容查询
    List<LabelEntity> findByLabelContentStringLike(String labelContentString);

    // 根据标签组编号查询
    List<LabelEntity> findByLabelGroupId(int labelGroupId);

    // 根据标签编号删除
    void deleteById(String labelNum);
}
