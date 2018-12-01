package edu.cs.hrbnu.model;

public class StudentCourse {
    private String studentId;
    private String courseId;
    /**
     *  评价次数，每学期需要由管理员设置最少评价次数
     * */
    private int courseTime;
    /**
     *  增加是否是历史课程标志
     * */
    private boolean history;

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

    public int getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(int courseTime) {
        this.courseTime = courseTime;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public boolean isHistory() {
        return history;
    }
}
