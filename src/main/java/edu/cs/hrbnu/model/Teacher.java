package edu.cs.hrbnu.model;

import java.util.Date;


public class Teacher {
    private String teacherId;
    private String password;
    private String teacherName;
    private String title;
    private String myselfEvaluateContent;
    private double myselfEvaluateScore;

    /**
     *  互帮互助部分
     * */
    private String helpTeacherName;
    private String accepterTeacherName;
    private String helpTeacherId;
    private String accepterTeacherId;

    /**
     *  教师类型，从上到下分别确定是否为：
     *  一般教师、领导、督导
     * */
    private boolean teacherType;
    private boolean leaderType;
    private boolean monitorType;

    private Date lastLoginTime;
    private String idCard;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMyselfEvaluateContent() {
        return myselfEvaluateContent;
    }

    public void setMyselfEvaluateContent(String myselfEvaluateContent) {
        this.myselfEvaluateContent = myselfEvaluateContent;
    }

    public double getMyselfEvaluateScore() {
        return myselfEvaluateScore;
    }

    public void setMyselfEvaluateScore(double myselfEvaluateScore) {
        this.myselfEvaluateScore = myselfEvaluateScore;
    }

    public String getHelpTeacherName() {
        return helpTeacherName;
    }

    public void setHelpTeacherName(String helpTeacherName) {
        this.helpTeacherName = helpTeacherName;
    }

    public String getAccepterTeacherName() {
        return accepterTeacherName;
    }

    public void setAccepterTeacherName(String accepterTeacherName) {
        this.accepterTeacherName = accepterTeacherName;
    }

    public String getHelpTeacherId() {
        return helpTeacherId;
    }

    public void setHelpTeacherId(String helpTeacherId) {
        this.helpTeacherId = helpTeacherId;
    }

    public String getAccepterTeacherId() {
        return accepterTeacherId;
    }

    public void setAccepterTeacherId(String accepterTeacherId) {
        this.accepterTeacherId = accepterTeacherId;
    }

    public boolean isTeacherType() {
        return teacherType;
    }

    public void setTeacherType(boolean teacherType) {
        this.teacherType = teacherType;
    }

    public boolean isLeaderType() {
        return leaderType;
    }

    public void setLeaderType(boolean leaderType) {
        this.leaderType = leaderType;
    }

    public boolean isMonitorType() {
        return monitorType;
    }

    public void setMonitorType(boolean monitorType) {
        this.monitorType = monitorType;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
