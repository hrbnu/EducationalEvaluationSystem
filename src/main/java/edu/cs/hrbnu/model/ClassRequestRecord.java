package edu.cs.hrbnu.model;

//申请听课记录
public class ClassRequestRecord {
    private String teacherId;
    private String isListenedTeacherId;
    private String courseId;
    private int id;
    //是否已经确认过
    private boolean confirmed;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getIsListenedTeacherId() {
        return isListenedTeacherId;
    }

    public void setIsListenedTeacherId(String isListenedTeacherId) {
        this.isListenedTeacherId = isListenedTeacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
