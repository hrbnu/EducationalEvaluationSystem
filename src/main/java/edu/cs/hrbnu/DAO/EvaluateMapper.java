package edu.cs.hrbnu.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.cs.hrbnu.model.Evaluate;

public interface EvaluateMapper {
    List<Evaluate> getOtherEvaluateById(String id) throws Exception;
    List<Evaluate> getAllTeacherEvaluate() throws Exception;
    int insertEvaluate(Evaluate evaluate) throws Exception;
    List<Evaluate> getEvaluateByCourseId(String id) throws Exception;
    List<Evaluate> getEvaluateScoreByStudentIdAndCourseId(@Param("studentId") String studentId,@Param("courseId") String courseId) throws Exception;
    List<Evaluate> getEealuateScoreByCourseIdAndFlag(@Param("courseId") String coureserId,@Param("flag") String flag) throws Exception;
    //删除单条学生评价信息
    void deleteSingleStudentEvaluates(String studentId) throws Exception;
    //根据课程号删除评价信息
    void deleteEvaluatesByCourseId(String courseId) throws Exception;
    //通过教师工号修改flagId
    void updateFlagIdByTeacherId(HashMap<String,Object> map) throws Exception;
    //通过学生号修改flagId
    void updateFlagIdByStudentId(HashMap<String,Object> map) throws Exception;
    //获取需要去评价的课程信息
    List<Evaluate> getNeedToEvaluateMessageByTeacherId(String teacherId);
}
