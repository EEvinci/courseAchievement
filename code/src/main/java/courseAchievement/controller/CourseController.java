package courseAchievement.controller;

import courseAchievement.entity.CourseEntity;
import courseAchievement.repository.CourseEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 设置前缀
@RequestMapping("/course")
public class CourseController {

    private final CourseEntityRepository repository;

    CourseController(CourseEntityRepository repository) {
        this.repository = repository;
    }

    /**
     * 根据课程编号查找课程
     * 
     * @param courseNum
     * @return
     */
    @PostMapping("/queryCourseByNum/{courseNum}")
    public CourseEntity queryCourseByNum(@PathVariable("courseNum") String courseNum) {
        CourseEntity course = CourseEntity.builder().courseNumString(courseNum).build(); // 创建一个课程对象
        // 查询数据库中的课程
        List<CourseEntity> courseList = repository.findByCourseNumStringLike(courseNum);
        // 判断是否查找到
        if (courseList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        // 返回第一个
        course = courseList.get(0);
        System.out.println("Found it");
        return course;
    }

    /**
     * 根据课程名称查找课程
     * 
     * @param courseName
     * @return
     */
    @PostMapping("/queryCourseByName/{courseName}")
    public CourseEntity queryCourseByName(@PathVariable("courseName") String courseName) {
        CourseEntity course = CourseEntity.builder().courseNameString(courseName).build();
        // 查询数据库中的课程
        List<CourseEntity> courseList = repository.findByCourseNameStringLike(courseName);
        if (courseList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        // 返回第一个
        course = courseList.get(0);
        System.out.println("Found it");
        return course;
    }

    /**
     * 添加课程
     * 
     * @param courseNum
     * @param courseName
     * @param courseDescription
     * @param courseCredit
     * @param courseBook
     * @param courseTeacher
     * @return
     */
    @PostMapping("/addCourse/{courseNum}/{courseName}/{courseDescription}/{courseCredit}/{courseBook}/{courseTeacher}")
    public CourseEntity addCourse(@PathVariable("courseNum") String courseNum,
            @PathVariable("courseName") String courseName,
            @PathVariable("courseDescription") String courseDescription,
            @PathVariable("courseCredit") String courseCredit,
            @PathVariable("courseBook") String courseBook,
            @PathVariable("courseTeacher") String courseTeacher) {

        CourseEntity course = CourseEntity.builder().courseNumString(courseNum).courseNameString(courseName)
                .courseDescriptionString(courseDescription).courseCreditString(courseCredit)
                .courseBookString(courseBook).courseTeacherId(0).build();
        // 保存到数据库
        repository.save(course);
        // 判断是否保存成功
        if (repository.findByCourseNumStringLike(courseNum).size() == 0) {
            System.out.println("Add Failed");
            return null;
        }
        return course;
    }

    /**
     * 查看所有课程
     * 
     * @return
     */
    @PostMapping("/findAllCourse")
    public List<CourseEntity> findAll() {
        List<CourseEntity> courseList = repository.findAll();
        // 判断是否查找到
        if (courseList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        return courseList;
    }

    /**
     * 根据课程编号删除课程
     * 
     * @param courseNum
     */
    @PostMapping("/deleteCourse/{courseNum}")
    public void delete(@PathVariable String courseNum) {
        repository.deleteById(courseNum);
        // 判断是否删除成功
        if (repository.findByCourseNumStringLike(courseNum).size() == 0) {
            System.out.println("Delete Success");
        } else {
            System.out.println("Delete Failed");
        }
    }

}
