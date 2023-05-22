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
    KnowledgeEntity findByKnowledgeNum(String knowledgeNum);

    // 根据知识点名称查询
    KnowledgeEntity findByKnowledgeTitle(String knowledgeTitle);


}
