package com.evinci.courseAchievement.formbean.CourseForm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// TODO 对所有的formbean添加Lombok注解，使用流式方法在service包的impl中进行流式填充
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminCreateCourseForm {

    private String courseNum;
    private String courseName;
    private String courseDescription;
    private String courseCredit;
    private String courseBook;

}
