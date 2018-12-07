package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.model.Administrator;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.AdministratorService;
import org.springframework.stereotype.Service;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Override
    public void login(Administrator administrator){
        // TODO
    }

    @Override
    public void logout(Administrator administrator){
        // TODO
    }

    @Override
    public void importStudentByExcel(){
        // TODO
    }

    @Override
    public void insertStudent(Student student){
        // TODO
    }

    @Override
    public void updateStudent(Student student){
        // TODO
    }

    @Override
    public void deleteStudent(Student student){
        // TODO
    }

    @Override
    public void importCourseByExcel(){
        // TODO
    }

    @Override
    public void updateCourseByExcel(){
        // TODO
    }

    @Override
    public void updateGrading(){
        // TODO
    }

    @Override
    public void generalComment(){
        // TODO
    }

    @Override
    public void importTeacherByExcel(){
        // TODO
    }

    @Override
    public void insertTeacher(Teacher teacher){
        // TODO
    }

    @Override
    public void updateTeacher(Teacher teacher){
        // TODO
    }

    @Override
    public void deleteTeacher(Teacher teacher){
        // TODO
    }
}
