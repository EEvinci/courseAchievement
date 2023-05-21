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
    public Integer createOneLabelGroup(LabelGroupEntity labelGroupEntity) throws ResourceNotFoundException {
        return null;
    }
}