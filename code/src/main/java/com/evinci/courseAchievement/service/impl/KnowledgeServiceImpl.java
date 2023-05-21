package com.evinci.courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.KnowledgeForm.KnowledgeForm;
import com.evinci.courseAchievement.service.KnowledgeService;
import com.evinci.courseAchievement.entity.KnowledgeEntity;
import com.evinci.courseAchievement.repository.KnowledgeEntityRepository;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Override
    public Integer createOneKnowledge(KnowledgeEntity knowledgeEntity) throws ResourceNotFoundException {
        return null;
    }
}