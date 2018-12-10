package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Teacher;

public interface TeacherMapper {
	Teacher getTeacherById(String id) throws Exception;
	int updateHelpByHelperId(String fromId,String toId) throws Exception;
	int updateHelpByAccepterId(String toId,String fromId) throws Exception;
    int insertTeacher(Teacher teacher) throws Exception;
}
