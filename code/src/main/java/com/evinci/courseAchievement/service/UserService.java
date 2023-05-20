package com.evinci.courseAchievement.service;

import java.util.List;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.TeacherForm;
import com.evinci.courseAchievement.entity.UserEntity;

public interface TeacherService {
    public List<TeacherForm> findAllTeachers() throws ResourceNotFoundException;

    public TeacherForm findTeacherById(Integer id) throws ResourceNotFoundException;

    public List<TeacherForm> findTeacherByTeacherId(String teacherId) throws ResourceNotFoundException;

    public Integer updateOneTeacher(UserEntity teacherEntity) throws ResourceNotFoundException;

    public Integer createOneTeacher(UserEntity teacherEntity) throws ResourceNotFoundException;

    public Integer deleteOneTeacher(Integer id) throws ResourceNotFoundException;
}
