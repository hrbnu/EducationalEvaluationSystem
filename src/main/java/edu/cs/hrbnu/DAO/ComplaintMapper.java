package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Complaint;

import java.util.HashMap;
import java.util.List;

public interface ComplaintMapper {
    int insertComplaintContent(Complaint complaint) throws Exception;
    List<Complaint> getComplaintByStudentId(String studentId) throws Exception;
    List<Complaint> getAllComplaint() throws Exception;
    List<Complaint> getComplaintByCourseId(String courseId) throws Exception;
    //删除单条学生投诉信息
    void deleteSingleStudentComplaints(String studentId) throws Exception;
    //根据课程号删除投诉信息
    void deleteComplaintsByCourseId(String courseId) throws Exception;
    //修改单条学生号
    void updateSingleStudentId(HashMap<String,Object> map) throws Exception;
}
