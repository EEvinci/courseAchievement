package courseAchievement.formbean;

import java.sql.Timestamp;

public class ExampleLikeHistoryForm {
    private int exampleIid;
    private Timestamp likeTime;

    public int getExampleIid() {
        return exampleIid;
    }

    public void setExampleIid(int exampleIid) {
        this.exampleIid = exampleIid;
    }

    public Timestamp getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Timestamp likeTime) {
        this.likeTime = likeTime;
    }
}
