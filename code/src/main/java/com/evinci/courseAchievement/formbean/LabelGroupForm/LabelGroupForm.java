package com.evinci.courseAchievement.formbean.LabelGroupForm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelGroupForm {
    private int id;
    private String labelGroupId;
    private String labelGroupDescription;

}
