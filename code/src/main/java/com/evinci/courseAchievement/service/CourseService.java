package com.evinci.courseAchievement.service;

import java.util.List;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.CourseForm.AdminCreateCourseForm;
import com.evinci.courseAchievement.entity.CourseEntity;;

public interface CourseService {

    public Integer createCourse(CourseEntity courseEntity) throws ResourceNotFoundException;

//    // 从formbean中获取数据，将其转换为entity，然后调用repository中的方法将entity存入数据库
//    List<CourseForm> findAllCourse() throws ResourceNotFoundException;

//    public Integer deleteCourse(Integer id) throws ResourceNotFoundException;
//
//    // 查找所有的课程
//    public List<CourseForm> findAllCourse() throws ResourceNotFoundException;
//
//    // 根据课程id查找课程
//    public CourseForm findCourseById(Integer id) throws ResourceNotFoundException;
//
//    public Integer updateOneCourse(CourseEntity courseEntity) throws ResourceNotFoundException;
//
//
//    // 用于根据提供的CourseForm对象的属性来过滤和查找课程
//    public List<CourseForm> findCourse(CourseForm courseForm) throws ResourceNotFoundException;
}
