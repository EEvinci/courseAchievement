package com.evinci.courseAchievement.formbean.UserForm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private int id;
    private String teacherId;
    private String teacherName;
    private String teacherPhone;
    private String teacherDescription;

}
