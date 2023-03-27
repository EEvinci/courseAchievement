package courseAchievement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import courseAchievement.model.Course;

import java.util.UUID;

@RestController
//设置前缀
@RequestMapping("/course")
public class CourseController {

    //根据编号查找特定的课程
    @GetMapping("/queryCourseByNum/{courseNum}")
    public Course queryCourseByNum(@PathVariable("courseNum") String courseNum) {
        Course course = new Course();
        course.setCourseNum(courseNum);
        System.out.println("Found it");
        return course;
    }

    //根据名称查找特定的课程
    @GetMapping("/queryCourseByName/{courseName}")
    public Course queryCourseByName(@PathVariable("courseName") String courseName) {
        Course course = new Course();
        course.setCourseName(courseName);
        System.out.println("Found it");
        return course;
    }

    //根据教材查找特定的课程
    @GetMapping("/queryCourseByTextBook/{textbook}")
    public Course queryCourseByTextBook(@PathVariable("textbook") String textbook) {
        Course course = new Course();
        course.setTextbook(textbook);
        System.out.println("Found it");
        return course;
    }

    //根据老师查找特定的课程
    @GetMapping("/queryCourseByTeacher/{courseTeacher}")
    public Course queryCourseByTeacher(@PathVariable("courseTeacher") String courseTeacher) {
        Course course = new Course();
        course.setCourseTeacher(courseTeacher);
        System.out.println("Found it");
        return course;
    }

    //更新课程信息
    @RequestMapping("/updateCourse/{courseNum}/{courseName}/{courseDescription}/{textbook}/{courseLabel}/{courseTeacher}")
    public Course updateCourse(@PathVariable("courseNum") String courseNum,
                               @PathVariable("courseName") String courseName,
                               @PathVariable("courseDescription") String courseDescription,
                               @PathVariable("textbook") String textbook,
                               @PathVariable("courseLabel") String[] courseLabel,
                               @PathVariable("courseTeacher") String courseTeacher) {
        Course course = new Course();
        course.setCourseNum(courseNum);
        course.setCourseName(courseName);
        course.setCourseDescription(courseDescription);
        course.setTextbook(textbook);
        course.setCourseLabel(courseLabel);
        course.setCourseTeacher(courseTeacher);
        System.out.println("Successfully update the information of "+courseName);
        return course;
    }


    //删除课程
    @RequestMapping("/deleteCourse/{courseNum}")
    public String deleteCourse(@PathVariable("courseNum") String courseNum) {
        System.out.println("Successfully delete");
        return "Successfully delete the course which courseNum is " + courseNum;
    }

    //增加课程
    @RequestMapping("/addCourse/{courseNum}/{courseName}/{courseDescription}/{textbook}/{courseLabel}/{courseTeacher}")
    public Course addCourse(@PathVariable("courseNum") String courseNum,
                            @PathVariable("courseName") String courseName,
                            @PathVariable("courseDescription") String courseDescription,
                            @PathVariable("textbook") String textbook,
                            @PathVariable("courseLabel") String[] courseLabel,
                            @PathVariable("courseTeacher") String courseTeacher) {
        Course course = new Course();
        String preUuid = UUID.randomUUID().toString();
        course.setId(preUuid);
        course.setCourseNum(courseNum);
        course.setCourseName(courseName);
        course.setCourseDescription(courseDescription);
        course.setTextbook(textbook);
        course.setCourseLabel(courseLabel);
        course.setCourseTeacher(courseTeacher);
        System.out.println("Successfully add the information of "+courseName);
        return course;
    }

    public static void main(String[] args) {
        String courseNum = "2001";
        String courseName = "RA";
        String courseDescription = "Good course";
        String textbook = "Book";
        String courseLabel = "CS";
        String courseTeacher = "PB";

    }

}
