package courseAchievement.model;

import lombok.Data;

@Data
public class Label {

    //定义id
    private String id;

    //定义标签编号
    private String labelNum;

    //定义标签内容
    private String labelContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelNum() {
        return labelNum;
    }

    public void setLabelNum(String labelNum) {
        this.labelNum = labelNum;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public void setLabelContent(String labelContent) {
        this.labelContent = labelContent;
    }
}
