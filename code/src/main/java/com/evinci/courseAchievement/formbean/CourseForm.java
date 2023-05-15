package com.evinci.courseAchievement.formbean;

// TODO 对所有的formbean添加Lombok注解，使用流式方法在service包的impl中进行流式填充
public class CourseForm {
    private int id;
    private String courseId;
    private  String courseName;
    private String courseDescripiton;

    private float courseCredit;

    private String courseUsedBook;

    private  int teacherIid;

    public int getIid() {
        return id;
    }

    public void setIid(int id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescripiton() {
        return courseDescripiton;
    }

    public void setCourseDescripiton(String courseDescripiton) {
        this.courseDescripiton = courseDescripiton;
    }

    public float getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(float courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseUsedBook() {
        return courseUsedBook;
    }

    public void setCourseUsedBook(String courseUsedBook) {
        this.courseUsedBook = courseUsedBook;
    }

    public int getTeacherIid() {
        return teacherIid;
    }

    public void setTeacherIid(int teacherIid) {
        this.teacherIid = teacherIid;
    }
}
