package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Complaint;
import edu.cs.hrbnu.model.Teacher;
import org.apache.ibatis.annotations.Param;

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
    //更新教师上次登录时间
    void updateLastLoginTime(@Param("currentLoginTime") String currentLoginTime,@Param("teacherId") String teacherId) throws Exception;
    //获取教师所教的课程
    List<String> getTeacherCoursesById(String teacherId);
    //获取课程Id集合中未浏览的投诉（从上次登录时间开始计算，区间内出现的投诉就是未浏览投诉）
    List<Complaint> getUnbrowsedComplaintsByCourseId(@Param("list") List<String> teacherId,@Param("lastLoginTime") String lastLoginTime,@Param("currentLoginTime") String currentLoginTime);
}
