package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Teacher;

import java.util.HashMap;
import java.util.List;

public interface TeacherMapper {
	Teacher getTeacherById(String id) throws Exception;
	int updateHelpByHelperId(String fromId,String toId) throws Exception;
	int updateHelpByAccepterId(String toId,String fromId) throws Exception;
    int insertTeacher(Teacher teacher) throws Exception;

    //更新密码
    void updateTeacherPasswordById(HashMap<String,Object> map) throws Exception;
    //更新密码前先验证用户名和密码是否匹配
    String validateTeacherIdAndPassword(String teacherId) throws Exception;
    // 重置密码
    void resetTeacherPassword(Teacher teacher) throws Exception;
    //重置密码时先获取教师信息
    Teacher getTeacherInformation(Teacher teacher) throws Exception;
    List<Teacher> getTeacherName() throws Exception;
}
