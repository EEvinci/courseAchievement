package com.evinci.courseAchievement.service;

import java.util.*;

import com.evinci.courseAchievement.entity.LabelGroupEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.LabelGroupForm.LabelGroupForm;

public interface LabelGroupService {

    public Integer createOneLabelGroup(LabelGroupEntity labelGroupEntity) throws  ResourceNotFoundException;

//    public List<LabelGroupForm> findAllLabelGroup() throws ResourceNotFoundException;
//    public LabelGroupForm findLabelGroupById(Integer id) throws ResourceNotFoundException;
//    public Integer updateOneLabelGroup(LabelGroupEntity labelGroupEntity) throws  ResourceNotFoundException;
//    public Integer deleteOneLabelGroup(Integer id) throws  ResourceNotFoundException;


}
