package com.evinci.courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.evinci.courseAchievement.formbean.TeacherForm;
import com.evinci.courseAchievement.repository.TeacherEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evinci.courseAchievement.exception.ResourceNotFoundException;

import com.evinci.courseAchievement.service.TeacherService;
import com.evinci.courseAchievement.entity.TeacherEntity;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherEntityRepository teacherEntityRepository;
    @Override
    public List<TeacherForm> findAllTeachers() throws ResourceNotFoundException {
        List<TeacherEntity> oldList =  teacherEntityRepository.findAll();
        if(oldList ==null){
            throw  new ResourceNotFoundException("No teacher found!");
        }

        List<TeacherForm> newList = new ArrayList<>();
        for(int i=0;i<oldList.size();i++){
            TeacherForm teacherForm = new TeacherForm();
            teacherForm.setIid(oldList.get(i).getId());
            teacherForm.setTeacherId(oldList.get(i).getTeacherNum());
            teacherForm.setTeacherName(oldList.get(i).getTeacherName());
            teacherForm.setTeacherPhone(oldList.get(i).getTeacherPhone());
            teacherForm.setTeacherDescription(oldList.get(i).getTeacherDescription());
            newList.add(teacherForm);
        }
        return newList;
    }
    @Override
    public TeacherForm findTeacherById(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTeacherById'");
    }
    @Override
    public List<TeacherForm> findTeacherByTeacherId(String teacherId) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTeacherByTeacherId'");
    }
    @Override
    public Integer updateOneTeacher(TeacherEntity teacherEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneTeacher'");
    }
    @Override
    public Integer createOneTeacher(TeacherEntity teacherEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOneTeacher'");
    }
    @Override
    public Integer deleteOneTeacher(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneTeacher'");
    }
}