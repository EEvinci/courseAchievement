package com.evinci.courseAchievement.controller;

import com.evinci.courseAchievement.repository.CourseEntityRepository;
import com.evinci.courseAchievement.service.CourseService;
import com.evinci.courseAchievement.entity.CourseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author evinci
 * @version 2.0
 */
@RestController
// 设置前缀
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

/**
 * 
 */

}
