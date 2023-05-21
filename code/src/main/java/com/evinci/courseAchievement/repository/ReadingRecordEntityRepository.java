package com.evinci.courseAchievement.repository;

import com.evinci.courseAchievement.entity.ReadingRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReadingRecordEntityRepository extends JpaRepository<ReadingRecordEntity, Integer> {

    Integer countByKnowledgeId(Integer knowledgeId);

    Page<ReadingRecordEntity> findByKnowledgeId(Integer knowledgId, Pageable pageable);
}