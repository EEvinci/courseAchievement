package com.evinci.courseAchievement.service;

import java.util.List;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.ExampleForm;
import com.evinci.courseAchievement.entity.ExampleEntity;;

public interface ExampleService {
    public List<ExampleForm> findAllExample() throws ResourceNotFoundException;

    public ExampleForm findExampleById(Integer id) throws ResourceNotFoundException;

    public Integer updateOneExample(ExampleEntity exampleEntity) throws ResourceNotFoundException;

    public Integer createOneExample(ExampleEntity exampleEntity) throws ResourceNotFoundException;

    public Integer deleteOneExample(Integer id) throws ResourceNotFoundException;
}
