package courseAchievement.model;

import lombok.Data;

import java.util.List;

@Data
public class KnowledgePoint {
    //定义id
    private String id;

    //定义知识点名称
    private String knowledgePointName;

    //定义知识点描述
    private String knowledgePointDescription;

    //定义重点说明
    private String knowledgePointMainlyExplain;

    //定义案例
    private String[] knowledgePointCase;

    //定义前置知识点
    private List<KnowledgePoint> knowledgePointPreview;

    //定义标签
    private String[] knowledgePointLabel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKnowledgePointName() {
        return knowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName) {
        this.knowledgePointName = knowledgePointName;
    }

    public String getKnowledgePointDescription() {
        return knowledgePointDescription;
    }

    public void setKnowledgePointDescription(String knowledgePointDescription) {
        this.knowledgePointDescription = knowledgePointDescription;
    }

    public String getKnowledgePointMainlyExplain() {
        return knowledgePointMainlyExplain;
    }

    public void setKnowledgePointMainlyExplain(String knowledgePointMainlyExplain) {
        this.knowledgePointMainlyExplain = knowledgePointMainlyExplain;
    }

    public String[] getKnowledgePointCase() {
        return knowledgePointCase;
    }

    public void setKnowledgePointCase(String[] knowledgePointCase) {
        this.knowledgePointCase = knowledgePointCase;
    }

    public List<KnowledgePoint> getKnowledgePointPreview() {
        return knowledgePointPreview;
    }

    public void setKnowledgePointPreview(List<KnowledgePoint> knowledgePointPreview) {
        this.knowledgePointPreview = knowledgePointPreview;
    }

    public String[] getKnowledgePointLabel() {
        return knowledgePointLabel;
    }

    public void setKnowledgePointLabel(String[] knowledgePointLabel) {
        this.knowledgePointLabel = knowledgePointLabel;
    }
}
