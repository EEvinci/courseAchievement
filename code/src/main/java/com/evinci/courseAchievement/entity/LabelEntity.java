package com.evinci.courseAchievement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author evinci
 * @version 1.0
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "label", schema = "courseachievement", catalog = "")
public class LabelEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "label_num")
  private String labelNum;

  @Column(name = "label_content")
  private String labelContent;

  // 标签类型：用以判别（系统内置/用户自定义）标签
  @Column(name = "lable_type")
  private String labeltype;


  // 多对多关系 标签与标签组
  @ManyToMany(mappedBy = "labels")
  @JoinTable(
    name = "label_label_group",
    joinColumns = @JoinColumn(name = "label_id"),
    inverseJoinColumns = @JoinColumn(name = "label_group_id")
  )
  @Builder.Default
  private Set<LabelGroupEntity> LabelGroupId = new HashSet<>();


  // 多对多关系 标签与课程
  @ManyToMany
  // @JoinTable表示该字段是一个多对多关系，name表示中间表的表名，joinColumns表示中间表中的外键字段，inverseJoinColumns表示中间表中的另一个外键字段
  // 创建一个连接表，连接表中有两个字段，一个是label_id，一个是course_id，分别对应LabelEntity和CourseEntity的主键
  @JoinTable(name = "course_label", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
  @Builder.Default
  private Set<CourseEntity> courses = new HashSet<CourseEntity>();


  // 多对多关系 标签与知识点
  @ManyToMany
  @JoinTable(name = "label_group_label", joinColumns = @JoinColumn(name = "label_group_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
  @Builder.Default
  private Set<KnowledgeEntity> knowledges = new HashSet<>();

}
