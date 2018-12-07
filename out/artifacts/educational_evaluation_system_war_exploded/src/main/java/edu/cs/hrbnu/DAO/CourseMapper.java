package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Course;

import java.util.List;

public interface CourseMapper {
    Course getCourseById(String id) throws Exception;
}
