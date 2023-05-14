package com.evinci.courseAchievement.formbean;

public class LabelForm {
    private int id;
    private String labelId;
    private String labelContent;



    private int labelGroupIid;
    public int getIid() {
        return id;
    }

    public void setIid(int id) {
        this.id = id;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public void setLabelContent(String labelContent) {
        this.labelContent = labelContent;
    }
    public int getLabelGroupIid() {
        return labelGroupIid;
    }

    public void setLabelGroupIid(int labelGroupIid) {
        this.labelGroupIid = labelGroupIid;
    }
}
