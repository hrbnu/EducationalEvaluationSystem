package edu.cs.hrbnu.model;

/**
 * 在遍历学生当前课程时，需要获得老师信息，课程信息
 * @author Administrator
 *
 */
public class StudentCourseTemp {
	private Course course;
	private Teacher teacher;
	private StudentCourse studentCourse;
	public StudentCourse getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(StudentCourse studentCourse) {
		this.studentCourse = studentCourse;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


}
