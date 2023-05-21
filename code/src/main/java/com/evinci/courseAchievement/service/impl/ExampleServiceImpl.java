package com.evinci.courseAchievement.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.evinci.courseAchievement.formbean.ExampleForm;
import com.evinci.courseAchievement.service.ExampleService;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.entity.ExampleEntity;
import com.evinci.courseAchievement.repository.ExampleEntityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExampleEntityRepository exampleEntityRepository;


    @Override
    public Integer createOneExample(ExampleEntity exampleEntity) throws ResourceNotFoundException {
        return null;
    }
}