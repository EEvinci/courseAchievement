package com.evinci.courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evinci.courseAchievement.entity.KnowledgeEntity;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface KnowledgeEntityRepository extends JpaRepository<KnowledgeEntity, Integer> {
    // 根据知识点编号查询
    List<KnowledgeEntity> findByKnowledgeNumStringLike(String knowledgeNumString);

    // 根据知识点名称查询
    List<KnowledgeEntity> findByKnowledgeVitalString(String knowledgeVitalString);

    // 根据知识点描述查询
    List<KnowledgeEntity> findByKnowledgeDescriptionString(String knowledgeDescriptionString);

    // 根据知识点编号删除
    void deleteById(String knowledgeNum);

}
