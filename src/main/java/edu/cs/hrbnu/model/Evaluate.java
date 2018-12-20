package edu.cs.hrbnu.model;

public class Evaluate {

    private int id;
    private String courseId;
    private String evaluateContent;
    private double evaluateScore;
    /**
     *  标志位，学生的评价还是教师、督导的评价  1学生 2教师 3督导
     * */
    private String flag;
    // 学号或者工号
    private String flagId;
    //老师是否评价课程
    private boolean alreadyEvaluate;

    public boolean isAlreadyEvaluate() {
        return alreadyEvaluate;
    }

    public void setAlreadyEvaluate(boolean alreadyEvaluate) {
        this.alreadyEvaluate = alreadyEvaluate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public String getFlagId() {
        return flagId;
    }

    public void setFlagId(String flagId) {
        this.flagId = flagId;
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
