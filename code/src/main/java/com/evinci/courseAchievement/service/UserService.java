package com.evinci.courseAchievement.service;

import java.util.List;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.evinci.courseAchievement.entity.UserEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.UserForm.UserForm;

public interface UserService {
    public Integer addUser(UserEntity userEntity) throws ResourceNotFoundException;
}
