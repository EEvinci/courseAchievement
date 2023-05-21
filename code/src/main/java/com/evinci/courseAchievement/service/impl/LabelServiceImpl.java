package com.evinci.courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.evinci.courseAchievement.repository.LabelEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.LabelForm.LabelForm;
import com.evinci.courseAchievement.service.LabelService;
import com.evinci.courseAchievement.entity.LabelEntity;

@Service
public class LabelServiceImpl implements LabelService {

    @Override
    public Integer createOneLabel(LabelEntity labelEntity) throws ResourceNotFoundException {
        return null;
    }
}