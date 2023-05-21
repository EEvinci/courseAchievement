package com.evinci.courseAchievement.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * 用户实体
 * 老师/学生/管理员
 * 采取统一身份认证
 */
@Table(name = "user", schema = "courseachievement", catalog = "")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_account")
    private String userAccount;  // 老师的工号中有字母，学生的学号全是数字

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_phone")
    private String userPhone;


    /*
    user_type中包含teacher/student/admin
     */
    public enum UserType {
        TEACHER,
        STUDENT,
        ADMIN
    }
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)  // String类型的枚举
    private UserType userType;


    // 多对多关系 用户与课程
    // 在这里因为枚举的原因，所以之后在业务逻辑中要进行判断
    // 比如添加课程：只有管理员能够添加课程
    @ManyToMany
    @JoinTable(name = "user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @Builder.Default
    private Set<CourseEntity> courses = new HashSet<>();
}
