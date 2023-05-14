package com.evinci.courseAchievement.service;

import java.util.List;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.CourseForm;
import com.evinci.courseAchievement.entity.CourseEntity;;

public interface CourseService {

    public Integer createOneCourse(CourseEntity courseEntity) throws ResourceNotFoundException;

    public Integer deleteOneCourse(Integer id) throws ResourceNotFoundException;

    // 查找所有的课程
    public List<CourseForm> findAllCourse() throws ResourceNotFoundException;

    // 根据课程id查找课程
    public CourseForm findCourseById(Integer id) throws ResourceNotFoundException;

    public Integer updateOneCourse(CourseEntity courseEntity) throws ResourceNotFoundException;

    // 用于根据提供的CourseForm对象的属性来过滤和查找课程
    public List<CourseForm> findCourse(CourseForm courseForm) throws ResourceNotFoundException;
}
