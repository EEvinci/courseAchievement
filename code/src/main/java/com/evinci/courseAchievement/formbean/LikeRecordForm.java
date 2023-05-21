package com.evinci.courseAchievement.formbean;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeRecordForm {
    private int exampleIid;
    private Timestamp likeTime;

}
