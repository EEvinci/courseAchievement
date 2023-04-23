package courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courseAchievement.service.CourseService;
import courseAchievement.exception.ResourceNotFoundException;
import courseAchievement.formbean.CourseForm;
import courseAchievement.entity.CourseEntity;
import courseAchievement.repository.CourseEntityRepository;

@Service
public class CourseServiceImpl implements CourseService {

    // AutoWired的作用是将CourseEntityRepository这个类的实例注入到CourseServiceImpl中，从而使得CourseServiceImpl可以使用CourseEntityRepository中的方法
    @Autowired
    private CourseEntityRepository courseEntityRepository;

    @Override
    // 从formbean中获取数据，将其转换为entity，然后调用repository中的方法将entity存入数据库
    public List<CourseForm> findAllCourse() throws ResourceNotFoundException {
        List<CourseEntity> oldList = courseEntityRepository.findAll();
        if (oldList == null) {
            throw new ResourceNotFoundException("No class found!");
        }
        List<CourseForm> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            CourseForm courseForm = new CourseForm();
            courseForm.setIid(oldList.get(i).getId());
            courseForm.setCourseId(oldList.get(i).getCourseNumString());
            courseForm.setCourseName(oldList.get(i).getCourseNameString());
            courseForm.setCourseDescripiton(oldList.get(i).getCourseDescriptionString());
            courseForm.setCourseUsedBook(oldList.get(i).getCourseBookString());
            courseForm.setTeacherIid(oldList.get(i).getCourseTeacherId());
            newList.add(courseForm);
        }
        return newList;
    }

    @Override
    public Integer createOneCourse(CourseEntity courseEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOneCourse'");
    }

    @Override
    public Integer deleteOneCourse(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneCourse'");
    }

    @Override
    public CourseForm findCourseByIid(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCourseByIid'");
    }

    @Override
    public List<CourseForm> findCourse(CourseForm courseForm) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCourse'");
    }

    @Override
    public Integer updateOneCourse(CourseEntity courseEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneCourse'");
    }

}
