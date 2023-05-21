package com.evinci.courseAchievement.formbean.KnowledgeForm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeForm {
    private int id;
    private String knowledgeId;
    private String knowledgeDescription;
    private String knowledgeImportantDescription;
    private Integer preKnowledgeIid;

}
