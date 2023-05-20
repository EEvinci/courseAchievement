package com.evinci.courseAchievement.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;
/**
 * @author evinci
 * @version 1.0
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * 标签组
 */
@Table(name = "label_group", schema = "courseachievement", catalog = "")
public class LabelGroupEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "label_group_num")
  private String labelGroupNum;

  @Column(name = "label_group_content")
  private String labelGroupContent;

  
  @ManyToMany(mappedBy = "LabelGroupId")
  @Builder.Default
  private Set<LabelEntity> labels = new HashSet<>();

}
