package com.evinci.courseAchievement.controller;

import com.evinci.courseAchievement.repository.TeacherEntityRepository;
import com.evinci.courseAchievement.entity.TeacherEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherEntityRepository repository;

    TeacherController(TeacherEntityRepository repository) {
        this.repository = repository;
    }

    /**
     * 根据老师编号查找老师
     * 
     * @param teacherNum
     * @return
     */
    @PostMapping("/queryteacherByNum/{teacherNum}")
    public TeacherEntity queryteacherByNum(@PathVariable("teacherNum") String teacherNum) {
        TeacherEntity teacher = TeacherEntity.builder().teacherNum(teacherNum).build(); // 创建一个老师对象
        // 查询数据库中的课程
        List<TeacherEntity> teacherList = repository.findByTeacherNumStringLike(teacherNum);
        // 判断是否查找到
        if (teacherList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        // 返回第一个
        teacher = teacherList.get(0);
        System.out.println("Found it");
        return teacher;
    }

    /**
     * 添加老师
     * 
     * @param teacherNum
     * @param teacherName
     * @param teacherPhone
     * @param teacherDescription
     * @return
     */
    @PostMapping("/addteacher/{teacherNum}/{teacherContent}/{teacherGroupId}")
    public TeacherEntity addteacher(@PathVariable("teacherNum") String teacherNum,
            @PathVariable("teacherName") String teacherName,
            @PathVariable("teacherPhone") String teacherPhone,
            @PathVariable("teacherDescription") String teacherDescription) {
        TeacherEntity teacher = TeacherEntity.builder().teacherNum(teacherNum).teacherName(teacherName)
                .teacherPhone(teacherPhone).teacherDescription(teacherDescription).build();
        // 保存到数据库
        repository.save(teacher);
        // 判断是否保存成功
        if (repository.findByTeacherNumStringLike(teacherNum).size() == 0) {
            System.out.println("Add Failed");
            return null;
        }
        return teacher;
    }

    /**
     * 查看所有老师
     * 
     * @return
     */
    @PostMapping("/findAllteacher")
    public List<TeacherEntity> findAll() {
        List<TeacherEntity> teacherList = repository.findAll();
        // 判断是否查找到
        if (teacherList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        return teacherList;
    }

    /**
     * 根据老师编号删除教师
     * 
     * @param teacherNum
     */
    @PostMapping("/deleteteacher/{teacherNum}")
    public void delete(@PathVariable String teacherNum) {
        repository.deleteById(teacherNum);
        // 判断是否删除成功
        if (repository.findByTeacherNumStringLike(teacherNum).size() == 0) {
            System.out.println("Delete Success");
        } else {
            System.out.println("Delete Failed");
        }
    }
}
