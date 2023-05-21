package com.evinci.courseAchievement.entity;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author evinci
 * @version 1.0
 */
@Entity  // 类注解，表示该类是一个实体类
@Data  // 类注解，提供类的get、set、equals、hashCode、canEqual、toString方法
@Builder  // 类注解，提供类的builder方法，可以使用流式的调用方法
@NoArgsConstructor  // 类注解，提供类的无参构造方法
@AllArgsConstructor   // 类注解，提供类的全参构造方法
/**
 * 课程实体
 */
@Table(name = "course", schema = "courseachievement", catalog = "")  // 类注解，表示该类对应的表名是 course，schema表示数据库名，catalog一般来说为空
public class CourseEntity {

  @Id  // 表示该字段是主键
  @Column(name = "id")  // 表示该字段对应的数据库中的字段名
  @GeneratedValue(strategy = GenerationType.AUTO)  // 表示该字段是自增的
  private int id; 

  @Column(name = "course_num")
  private String courseNum;  

  @Column(name = "course_name")
  private String courseName;  

  @Column(name = "course_description")
  private String courseDescription;

  @Column(name = "course_credit")
  private String courseCredit;

  @Column(name = "course_book")
  private String courseBook;


  /*
    多对多关系 课程与用户
    学生与课程是多对多关系，一个学生可以选修多门课程，一门课程也可以被多个学生选修
    一个课程可以有多个老师，一个老师也可以教授多门课程
    管理员与课程是多对多关系，一个管理员可以管理多门课程，一门课程也可以被多个管理员管理

    只有管理员能够添加和删除课程
    管理员和老师能够修改课程
    学生只能够查看课程

    以上的权限控制在service层实现
  */
  @ManyToMany(mappedBy = "courses")
  @Builder.Default
  private Set<UserEntity> users = new HashSet<>();


  // 多对多关系 课程与标签
  @ManyToMany(mappedBy = "courses")  // 交给label中的courses属性管理多对多关系
  @Builder.Default  // 为集合字段提供默认值，避免遭遇空指针异常
  private Set<LabelEntity> labels = new HashSet<>();  // 集合字段，表示该课程对应的标签集合


  // 多对多关系 课程与知识点
  @ManyToMany(mappedBy = "courses")
  @Builder.Default  
  private Set<KnowledgeEntity> knowledges = new HashSet<>();

}
