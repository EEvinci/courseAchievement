package courseAchievement.model;

import lombok.Data;

@Data
public class Course {
    //定义id
    private String id;

    //定义课程编号
    private String courseNum;

    //定义课程名称
    private String courseName;

    //定义课程简介
    private String courseDescription;

    //定义教材
    private String textbook;

    //定义标签
    private String[] courseLabel; // many lables -> arraylist

    //定义教学教师
    private String courseTeacher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getTextbook() {
        return textbook;
    }

    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    public String[] getCourseLabel() {
        return courseLabel;
    }

    public void setCourseLabel(String[] courseLabel) {
        this.courseLabel = courseLabel;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

}