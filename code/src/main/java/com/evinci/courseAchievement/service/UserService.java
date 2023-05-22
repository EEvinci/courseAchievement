package com.evinci.courseAchievement.service;

import java.util.List;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.evinci.courseAchievement.entity.UserEntity;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.formbean.UserForm.UserForm;

public interface UserService {
    // 这里的参数为什么是UserForm，而不是UserEntity？
    // 因为UserForm是用来接收前端传来的数据的，而UserEntity是用来存储数据的
    // 两者的区别在于，UserForm中的属性是String类型的，而UserEntity中的属性是Integer类型的
    // 所以在接收前端传来的数据时，需要用UserForm，而在存储数据时，需要用UserEntity

    // 为什么addUser函数的返回值是Integer，而不是UserEntity？
    // 因为在数据库中，id是自增的，所以在插入数据时，不需要手动指定id，所以不需要返回UserEntity
    
    // 为什么addUser函数的返回值是Integer，而不是void？
    // 因为在插入数据时，需要返回插入的数据的id，所以需要返回Integer
    public Integer addUser(UserForm userForm) throws ResourceNotFoundException;
}
