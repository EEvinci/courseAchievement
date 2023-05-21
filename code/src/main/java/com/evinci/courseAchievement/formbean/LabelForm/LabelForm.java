package com.evinci.courseAchievement.formbean.LabelForm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelForm {
    private int id;
    private String labelId;
    private String labelContent;
    private int labelGroupIid;

}
