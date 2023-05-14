package com.evinci.courseAchievement.exception;

public class ResourceNotFoundException extends RuntimeException{
    // 输出异常信息
    public ResourceNotFoundException(String argsString){
        super(argsString);
    }
    
}
