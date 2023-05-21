package com.evinci.courseAchievement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * 点赞记录实体
 * 只有案例可以点赞
 */
@Table(name = "like_record_history", schema = "courseachievement", catalog = "")
public class LikeRecordEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "example_id")
    private Integer exampleId;
    
    @Column(name = "like_timestamp")
    private Timestamp likeTimestamp;

}
