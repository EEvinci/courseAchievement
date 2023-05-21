package com.evinci.courseAchievement.service;

import java.util.List;

import com.evinci.courseAchievement.entity.KnowledgeEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.KnowledgeForm;
;

public interface KnowledgeService {

    public Integer createOneKnowledge(KnowledgeEntity knowledgeEntity) throws ResourceNotFoundException;

//    public Integer deleteOneKnowledge(Integer id) throws ResourceNotFoundException;
//
//    public List<KnowledgeForm> findAllKnowledge() throws ResourceNotFoundException;
//
//    public KnowledgeForm findKnowledgeById(Integer id) throws ResourceNotFoundException;
//
//    public KnowledgeForm findPreKnowledgeById(Integer id) throws ResourceNotFoundException;
//
//    public Integer updateOneKnowledge(KnowledgeEntity knowledgeEntity) throws ResourceNotFoundException;
//
//    // 根据preKnowledgeId 来进行查询
//    public List<KnowledgeForm> findAllUsingKnowledge(Integer id) throws ResourceNotFoundException;

}
