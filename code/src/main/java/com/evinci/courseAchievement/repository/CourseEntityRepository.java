package com.evinci.courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evinci.courseAchievement.entity.CourseEntity;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface CourseEntityRepository extends JpaRepository<CourseEntity, Integer> {
    // 根据课程编号查询
    CourseEntity findByCourseNum(String courseNum);

    // 根据课程名称查询
    CourseEntity findByCourseName(String courseName);

}
