package com.evinci.courseAchievement.repository;

import com.evinci.courseAchievement.entity.ReadingRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KnowledgeReadHistoryEntityRepository extends JpaRepository<ReadingRecordEntity, Integer> {

    Integer countByKnowledgeIid(Integer knowledgeIid);

    Page<ReadingRecordEntity> findByKnowledgeIid(Integer knowledgIid, Pageable pageable);
}