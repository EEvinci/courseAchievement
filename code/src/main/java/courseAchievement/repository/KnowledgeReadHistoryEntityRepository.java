package com.example.testjpa.repository;

import com.example.testjpa.entity.KnowledgeReadHistoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface KnowledgeReadHistoryEntityRepository extends JpaRepository<KnowledgeReadHistoryEntity, Integer> {


    Integer countByKnowledgeIid(Integer knowledgeIid);

    Page<KnowledgeReadHistoryEntity> findByKnowledgeIid(Integer knowledgIid, Pageable pageable);
}