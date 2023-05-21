package com.evinci.courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.evinci.courseAchievement.entity.UserEntity;
import com.evinci.courseAchievement.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.UserForm.UserForm;
import com.evinci.courseAchievement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Integer addUser(UserEntity userEntity) throws ResourceNotFoundException {
        return null;
    }
}