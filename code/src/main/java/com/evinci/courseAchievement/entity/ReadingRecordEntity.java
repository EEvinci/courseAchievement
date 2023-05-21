package com.evinci.courseAchievement.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * 阅读记录实体
 * 只记录知识点的阅读数量
 */
@Table(name = "reading_record_history", schema = "courseachievement", catalog = "")
public class ReadingRecordEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "knowledge_id")
    private Integer knowledgeId;

    @Column(name = "read_time")
    private Timestamp readTimestamp;
}
