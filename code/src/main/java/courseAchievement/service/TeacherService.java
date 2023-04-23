package courseAchievement.service;

import java.util.List;

import courseAchievement.exception.ResourceNotFoundException;
import courseAchievement.formbean.TeacherForm;
import courseAchievement.entity.TeacherEntity;

public interface TeacherService {
    public List<TeacherForm> findAllTeachers() throws ResourceNotFoundException;

    public TeacherForm findTeacherById(Integer iid) throws ResourceNotFoundException;

    public List<TeacherForm> findTeacherByTeacherId(String teacherId) throws ResourceNotFoundException;

    public Integer updateOneTeacher(TeacherEntity teacherEntity) throws ResourceNotFoundException;

    public Integer createOneTeacher(TeacherEntity teacherEntity) throws ResourceNotFoundException;

    public Integer deleteOneTeacher(Integer iid) throws ResourceNotFoundException;
}
