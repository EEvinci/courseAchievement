package com.example.testjpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "example_like_history", schema = "zuccqa", catalog = "")
public class ExampleLikeHistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "user_iid")
    private Integer userIid;
    @Basic
    @Column(name = "example_iid")
    private Integer exampleIid;
    @Basic
    @Column(name = "like_time")
    private Timestamp likeTime;

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

    public Integer getExampleIid() {
        return exampleIid;
    }

    public void setExampleIid(Integer exampleIid) {
        this.exampleIid = exampleIid;
    }

    public Timestamp getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Timestamp likeTime) {
        this.likeTime = likeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleLikeHistoryEntity that = (ExampleLikeHistoryEntity) o;
        return iid == that.iid && Objects.equals(userIid, that.userIid) && Objects.equals(exampleIid, that.exampleIid) && Objects.equals(likeTime, that.likeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, userIid, exampleIid, likeTime);
    }
}
