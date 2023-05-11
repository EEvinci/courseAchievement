package courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courseAchievement.exception.ResourceNotFoundException;

import courseAchievement.service.TeacherService;
import courseAchievement.formbean.TeacherForm;
import courseAchievement.entity.TeacherEntity;
import courseAchievement.repository.TeacherEntityRepository;

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
    public TeacherForm findTeacherById(Integer iid) throws ResourceNotFoundException {
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
    public Integer deleteOneTeacher(Integer iid) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneTeacher'");
    }
}