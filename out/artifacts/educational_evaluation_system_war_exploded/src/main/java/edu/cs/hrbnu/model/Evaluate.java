package edu.cs.hrbnu.model;

public class Evaluate {
    private String id;
    private String courseId;
    private String evaluateContent;
    private double evaluateScore;
    /**
     *  标志位，学生的评价还是教师、督导的评价
     * */
    private String flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public double getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(double evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
