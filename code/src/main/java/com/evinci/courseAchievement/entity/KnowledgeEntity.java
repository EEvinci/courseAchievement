package com.evinci.courseAchievement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

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
@Table(name = "knowledge", schema = "courseachievement", catalog = "")
public class KnowledgeEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  // 知识点标题
  @Column(name = "knowledge_title", nullable = false)
  private String knowledgeTitle;

  // 知识点内容
  @Column(name = "knowledge_description")
  private String knowledgeDescription;

  // 知识点与前置知识点
  @ManyToMany
  @JoinTable(
          name = "knowledge_prerequisites ",
          joinColumns = @JoinColumn(name = "knowledge_id"),
          inverseJoinColumns = @JoinColumn(name = "prerequisite_id")
  )
  private Set<KnowledgeEntity> prerequisites = new HashSet<>(); // 前置知识点


  // 多对多关系 知识点与后置知识点
  @ManyToMany
  @JoinTable(
          name = "knowledge_followUps",
          joinColumns = @JoinColumn(name = "knowledge_id"),
          inverseJoinColumns = @JoinColumn(name = "followUp_id")
  )
  @Builder.Default
  private Set<KnowledgeEntity> followUps = new HashSet<>();

  
  // 多对多关系 案例与知识点
  @ManyToMany
  @JoinTable(
          name = "example_knowledge",
          joinColumns = @JoinColumn(name = "example_id"),
          inverseJoinColumns = @JoinColumn(name = "knowledge_id")
  )
  @Builder.Default
  private Set<ExampleEntity> examples = new HashSet<ExampleEntity>();


  // 多对多关系 知识点与标签
  @ManyToMany
  @JoinTable(
          name = "knowledge_label",
          joinColumns = @JoinColumn(name = "knowledge_id"),
          inverseJoinColumns = @JoinColumn(name = "label_id")
  )
  @Builder.Default
  private Set<LabelEntity> labels = new HashSet<LabelEntity>();


  // 多对多关系 课程与知识点
// //   @ManyToMany
// //   @JoinTable(
// //           name = "course_knowledge",
// //           joinColumns = @JoinColumn(name = "knowledge_id"),
// //           inverseJoinColumns = @JoinColumn(name = "course_id")
// //   )
// //   @Builder.Default
// //   private Set<CourseEntity> courses = new HashSet<CourseEntity>();
}
