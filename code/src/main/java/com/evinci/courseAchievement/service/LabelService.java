package com.evinci.courseAchievement.service;

import java.util.List;

import com.evinci.courseAchievement.entity.LabelEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.LabelForm;

public interface LabelService {

    public Integer createOneLabel(LabelEntity labelEntity) throws ResourceNotFoundException;

//    public List<LabelForm> findAllLabel() throws ResourceNotFoundException;
//
//    public LabelForm findLabelById(Integer id) throws ResourceNotFoundException;
//
//    public Integer updateOneLabel(LabelEntity labelEntity) throws ResourceNotFoundException;
//
//    public Integer deleteOneLabel(Integer id) throws ResourceNotFoundException;
}
