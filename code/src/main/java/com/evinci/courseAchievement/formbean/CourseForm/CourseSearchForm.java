package com.evinci.courseAchievement.formbean.CourseForm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSearchForm {
    private String courseNum;
    private String courseName;
}
