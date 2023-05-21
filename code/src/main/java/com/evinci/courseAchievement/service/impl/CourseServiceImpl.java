package com.evinci.courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.service.CourseService;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.CourseForm.AdminCreateCourseForm;
import com.evinci.courseAchievement.entity.CourseEntity;
import com.evinci.courseAchievement.repository.CourseEntityRepository;

@Service
public class CourseServiceImpl implements CourseService {

    // AutoWired的作用是将CourseEntityRepository这个类的实例注入到CourseServiceImpl中，从而使得CourseServiceImpl可以使用CourseEntityRepository中的方法
    @Autowired
    private CourseEntityRepository courseEntityRepository;

    @Override
    public Integer createCourse(CourseEntity courseEntity) throws ResourceNotFoundException {
        return null;
    }
}
