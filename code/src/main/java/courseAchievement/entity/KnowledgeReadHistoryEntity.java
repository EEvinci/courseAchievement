package com.example.testjpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "knowledge_read_history", schema = "zuccqa", catalog = "")
public class KnowledgeReadHistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "user_iid")
    private Integer userIid;
    @Basic
    @Column(name = "knowledge_iid")
    private Integer knowledgeIid;
    @Basic
    @Column(name = "read_time")
    private Timestamp readTime;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public Integer getUserIid() {
        return userIid;
    }

    public void setUserIid(Integer userIid) {
        this.userIid = userIid;
    }

    public Integer getKnowledgeIid() {
        return knowledgeIid;
    }

    public void setKnowledgeIid(Integer knowledgeIid) {
        this.knowledgeIid = knowledgeIid;
    }

    public Timestamp getReadTime() {
        return readTime;
    }

    public void setReadTime(Timestamp readTime) {
        this.readTime = readTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnowledgeReadHistoryEntity that = (KnowledgeReadHistoryEntity) o;
        return iid == that.iid && Objects.equals(userIid, that.userIid) && Objects.equals(knowledgeIid, that.knowledgeIid) && Objects.equals(readTime, that.readTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, userIid, knowledgeIid, readTime);
    }
}
