package com.evinci.courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.evinci.courseAchievement.formbean.LabelGroupForm;
import com.evinci.courseAchievement.repository.LabelGroupEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;

import com.evinci.courseAchievement.service.LabelGroupService;
import com.evinci.courseAchievement.entity.LabelGroupEntity;

@Service
public class LabelGroupServiceImpl implements LabelGroupService {

    @Autowired
    private LabelGroupEntityRepository labelGroupEntityRepository;

    @Override
    public List<LabelGroupForm> findAllLabelGroup() throws ResourceNotFoundException {

        List<LabelGroupEntity> oldList = labelGroupEntityRepository.findAll();
        if (oldList == null) {
            throw new ResourceNotFoundException("No label group found!");
        }
        List<LabelGroupForm> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            LabelGroupForm labelGroupForm = new LabelGroupForm();
            labelGroupForm.setIid(oldList.get(i).getId());
            labelGroupForm.setLabelGroupId(oldList.get(i).getLabelGroupNum());
            labelGroupForm.setLabelGroupDescription(oldList.get(i).getLabelGroupContent());
            newList.add(labelGroupForm);
        }

        return newList;

    }

    @Override
    public LabelGroupForm findLabelGroupById(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findLabelGroupById'");
    }

    @Override
    public Integer createOneLabelGroup(LabelGroupEntity labelGroupEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOneLabelGroup'");
    }

    @Override
    public Integer updateOneLabelGroup(LabelGroupEntity labelGroupEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneLabelGroup'");
    }

    @Override
    public Integer deleteOneLabelGroup(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneLabelGroup'");
    }
}