package edu.cs.hrbnu.model;

import java.util.Date;

public class Complaint {
    private String studentId;
    private String courseId;
    private String message;
    private Date complaintTime;
    private Course course;

    public Course getCourse(){
        return course;
    }

    public void  setCourse(Course course){
        this.course = course;
    }

    public Date getComplaintTime() {
        return complaintTime;
    }

    public void setComplaintTime(Date complaintTime) {
        this.complaintTime = complaintTime;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
