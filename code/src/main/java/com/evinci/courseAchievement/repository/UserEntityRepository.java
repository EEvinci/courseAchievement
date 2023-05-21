package com.evinci.courseAchievement.repository;

import java.util.List;

import com.evinci.courseAchievement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    // 根据用户姓名查询
    UserEntity findByUserName(String userName);

    // 根据用户工号查询
    UserEntity findByUserAccount(String userAccount);


}
