package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.ClassRequestRecord;

import java.util.List;

public interface ClassRequestRecordMapper {
    List<ClassRequestRecord> getRequestRecord(String teacherId);
    void insertIntoRecord(String teacherId,String isListenedTeacherId,String courseId);
    void updateRequest(int classRequestRecordId);
}
