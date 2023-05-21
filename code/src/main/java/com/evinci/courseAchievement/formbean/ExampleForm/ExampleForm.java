package com.evinci.courseAchievement.formbean.ExampleForm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleForm {
    private int id;
    private String exampleNum;

    private String exampleUrl;

    
}
