package com.evinci.courseAchievement.repository;

import java.util.List;

import com.evinci.courseAchievement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    // 根据教师编号查询
    List<UserEntity> findByTeacherNumStringLike(String teacherNumString);

    // 根据教师姓名查询
    UserEntity findByTeacherNameStringLike(String teacherNameString);

    // 根据教师电话查询
    UserEntity findByTeacherPhoneStringLike(String teacherPhoneSting);

    // 根据教师编号删除
    void deleteById(String teacherNum);
}
