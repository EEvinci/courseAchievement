package courseAchievement.model;

import lombok.Data;

@Data
public class LabelGroup {

    //定义id
    private String id;

    //定义标签组编号
    private String labelGroupNum;

    //定义标签组内容
    private String[] labelGroupContent; // arraylist

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelGroupNum() {
        return labelGroupNum;
    }

    public void setLabelGroupNum(String labelGroupNum) {
        labelGroupNum = labelGroupNum;
    }

    public String[] getLabelGroupContent() {
        return labelGroupContent;
    }

    public void setLabelGroupContent(String[] labelGroupContent) {
        this.labelGroupContent = labelGroupContent;
    }
}
