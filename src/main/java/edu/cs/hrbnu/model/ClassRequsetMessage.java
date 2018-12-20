package edu.cs.hrbnu.model;

public class ClassRequsetMessage {
    private String requestTeacherName;
    private String requestTeacherId;
    private String requestIsListenedCourseName;
    //确认是否已确认
    private boolean confirmed;
    private String requestIsListenedCourseId;
    private int classRequestRecordId;

    public int getClassRequestRecordId() {
        return classRequestRecordId;
    }

    public void setClassRequestRecordId(int classRequestRecordId) {
        this.classRequestRecordId = classRequestRecordId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getRequestIsListenedCourseId() {
        return requestIsListenedCourseId;
    }

    public void setRequestIsListenedCourseId(String requestIsListenedCourseId) {
        this.requestIsListenedCourseId = requestIsListenedCourseId;
    }

    public boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getRequestTeacherName() {
        return requestTeacherName;
    }

    public void setRequestTeacherName(String requestTeacherName) {
        this.requestTeacherName = requestTeacherName;
    }

    public String getRequestTeacherId() {
        return requestTeacherId;
    }

    public void setRequestTeacherId(String requestTeacherId) {
        this.requestTeacherId = requestTeacherId;
    }

    public String getRequestIsListenedCourseName() {
        return requestIsListenedCourseName;
    }

    public void setRequestIsListenedCourseName(String requestIsListenedCourseName) {
        this.requestIsListenedCourseName = requestIsListenedCourseName;
    }
}
