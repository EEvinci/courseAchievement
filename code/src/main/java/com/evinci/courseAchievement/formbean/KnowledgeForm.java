package courseAchievement.formbean;

public class KnowledgeForm {
    private  int id;
    private String knowledgeId;
    private String knowledgeDescription;
    private String knowledgeImportantDescription;
    private Integer preKnowledgeIid;

    public int getIid() {
        return id;
    }

    public void setIid(int id) {
        this.id = id;
    }

    public String getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(String knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getKnowledgeDescription() {
        return knowledgeDescription;
    }

    public void setKnowledgeDescription(String knowledgeDescription) {
        this.knowledgeDescription = knowledgeDescription;
    }

    public String getKnowledgeImportantDescription() {
        return knowledgeImportantDescription;
    }

    public void setKnowledgeImportantDescription(String knowledgeImportantDescription) {
        this.knowledgeImportantDescription = knowledgeImportantDescription;
    }

    public Integer getPreKnowledgeIid() {
        return preKnowledgeIid;
    }

    public void setPreKnowledgeIid(Integer preKnowledgeIid) {
        this.preKnowledgeIid = preKnowledgeIid;
    }

}
