package com.evinci.courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.evinci.courseAchievement.formbean.KnowledgeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;

import com.evinci.courseAchievement.service.KnowledgeService;
import com.evinci.courseAchievement.entity.KnowledgeEntity;
import com.evinci.courseAchievement.repository.KnowledgeEntityRepository;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeEntityRepository knowledgeEntityRepository;

    @Override
    public List<KnowledgeForm> findAllKnowledge() throws ResourceNotFoundException {

        List<KnowledgeEntity> oldList = knowledgeEntityRepository.findAll();
        if (oldList == null) {
            throw new ResourceNotFoundException("No knowledge found!");
        }
        List<KnowledgeForm> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            KnowledgeForm knowledgeForm = new KnowledgeForm();
            knowledgeForm.setIid(oldList.get(i).getId());
            knowledgeForm.setKnowledgeId(oldList.get(i).getKnowledgeNum());
            knowledgeForm.setKnowledgeDescription(oldList.get(i).getKnowledgeDescription());
            knowledgeForm.setKnowledgeImportantDescription(oldList.get(i).getKnowledgeVital());
            knowledgeForm.setPreKnowledgeIid(oldList.get(i).getPreknowledgeId());
            newList.add(knowledgeForm);
        }
        return newList;
    }

    @Override
    public Integer createOneKnowledge(KnowledgeEntity knowledgeEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOneKnowledge'");
    }

    @Override
    public Integer deleteOneKnowledge(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneKnowledge'");
    }

    @Override
    public KnowledgeForm findKnowledgeById(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findKnowledgeById'");
    }

    @Override
    public KnowledgeForm findPreKnowledgeById(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPreKnowledgeById'");
    }

    @Override
    public List<KnowledgeForm> findAllUsingKnowledge(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllUsingKnowledge'");
    }

    @Override
    public Integer updateOneKnowledge(KnowledgeEntity knowledgeEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneKnowledge'");
    }
}