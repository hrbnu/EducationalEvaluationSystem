package edu.cs.hrbnu.service;

import edu.cs.hrbnu.model.*;

import java.util.List;

public interface TeacherService {
	/**
	 * 验证登录
	 * @param teacherId
	 * @param password
	 * @return
	 */
	Teacher login(String teacherId, String password);

	/**
     *  登出
     * */
	void logout();

	/**
	 *  重置密码 由void改成了boolean
	 * */
	boolean reset(Teacher teacher);

	/**
	 * 更新密码 由void改成了boolean
	 * @return
	 * */
	boolean updatePassword(String teacherId, String oldPassword, String newPassword);

	/**
	 * 查看自己评价信息
	 * @param teacherId
	 */
	List<Evaluate> otherEvaluate(String teacherId);

	/**
	 * 设置老师互帮信息
	 * @param teacherId 帮助者老师的id
	 * @param isHelpedTeacherId 被帮助老师的id
	 */
	void setHelp(String teacherId,String isHelpedTeacherId);

	/**
     * 提交听课申请
     * @param teacherId 申请老师的id
     * @param isListenedTeacherId 被请求听课老师的id
     */
	boolean submitListen(String teacherId,String isListenedTeacherId,String courseId);

	/**
     *  确认某老师已听课，由被听课老师手动确认，确认之后才能将评价写入数据库
     * */
	List<ClassRequsetMessage> confirm(String teacherId);

	/**
	 * 老师确认后，更改请求听课记录状态
	 * @param classRequestRecordId 请求听课的记录id
	 * @return
	 */
	void updateListen(int classRequestRecordId);


	/*===================================
	* yaque*/
	/*
	*获取老师的评分问题
	* */
	List<EvaluateProblem> getEvaluateProblem();
    /**
     *  评价某老师
     * */
    int evaluateTeacher(Evaluate evaluate);

    Course getCourseById(String courseId);

    /*===================================*/

	/**
	 * 浏览所有老师评价信息
	 */
	List<Evaluate> viewAllTeacherEvaluate();

	/**
	 * 浏览所有投诉信息
	 */
	List<Complaint> viewAllComplaint();

    /**
     *  浏览投诉自己的投诉信息
     * */
    Complaint viewMyComplaint();

    /**
     *  导出Excel的评价表
     * */
    List<Evaluate> exportEvaluateForm(String teacherId);

    /**
     *  显示未浏览投诉：从上次登录时间开始计算，区间内出现的投诉就是为浏览投诉
     * */
	List<Complaint> alertComplaint(String teacherId, String lastLoginTime, String currentLoginTime);
	List<Course> getCourseByTeahcer(String teacherId);
	List<Teacher> getAllTeacherName();
	List<Complaint> getComplaintByCourseId(String courseId);
	void updateLastLoginTime(String currentLoginTime,String teacherId);
	//获取需要去评价的课程信息
	List<TeacherAndCourseCombine> getNeedToEvaluateMessage(String teacherId);
	//得到单个老师的信息
	Teacher getSingleTeacherInfo(String teacherId);
	//保存听课申请
	void saveClassListen(int classListenId);

	List<Course> getCurrentMyselfEvaluate(String teahcerId);
}
