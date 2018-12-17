package edu.cs.hrbnu.service;

import edu.cs.hrbnu.model.Complaint;
import edu.cs.hrbnu.model.Evaluate;
import edu.cs.hrbnu.model.Teacher;

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
	void submitListen(String teacherId,String isListenedTeacherId);

	/**
     *  确认某老师已听课，由被听课老师手动确认，确认之后才能将评价写入数据库
     * */
	void confirm(Teacher teacher);

    /**
     *  评价某老师
     * */
    void evaluateTeacher(Evaluate evaluate);

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
    void exportEvaluateForm();

    /**
     *  显示未浏览投诉：从上次登录时间开始计算，区间内出现的投诉就是为浏览投诉
     * */
    List<Complaint> alertComplaint(String teacherId,String lastLoginTime,String currentLoginTime);
	/**
	 *  更新最后登录时间
	 */
	void updateLastLoginTime(String currentLoginTime,String teacherId);
}
