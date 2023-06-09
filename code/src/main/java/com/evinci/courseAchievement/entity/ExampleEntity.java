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
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * 案例实体
 */
@Table(name = "example", schema = "courseachievement", catalog = "")
public class ExampleEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "example_num")
    private String exampleNum;

    @Column(name = "example_content")
    private String exampleContent;

    // 多对多关系 案例与知识点
    @ManyToMany(mappedBy = "examples")
    @Builder.Default
    private Set<KnowledgeEntity> knowledges = new HashSet<>();
}
