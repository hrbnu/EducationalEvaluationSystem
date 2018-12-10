package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.StudentMapper;
import edu.cs.hrbnu.DAO.TeacherMapper;
import edu.cs.hrbnu.model.Administrator;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.AdministratorService;
import edu.cs.hrbnu.uitl.ExcelUitl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public void login(Administrator administrator){
        // TODO
    }

    @Override
    public void logout(Administrator administrator){
        // TODO
    }

    @Override
    public boolean importStudentByExcel(String filePath) {
        // 获取Workbook
        Workbook workbook = ExcelUitl.getWorkbook(filePath);
        if(workbook == null) return false;

        Sheet sheet = workbook.getSheetAt(0);
        int begin = sheet.getFirstRowNum()+1;
        int end = sheet.getLastRowNum();
        for(int i = begin;i <= end;i++){
            Row row = sheet.getRow(i);
            Student student = new Student();
            if(row == null) continue;

            // 构造student对象
            // 数字类只能获取为double，所以需要格式转换
            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);

            student.setStudentId(nf.format(row.getCell(0).getNumericCellValue()));
            student.setClassId(Integer.parseInt(nf.format(row.getCell(1).getNumericCellValue())));
            student.setIdCard(row.getCell(2).getStringCellValue());
            student.setName(row.getCell(3).getStringCellValue());
            student.setGrade(Integer.parseInt(nf.format(row.getCell(4).getNumericCellValue())));
            student.setDepartment(row.getCell(5).getStringCellValue());

            // 补充属性
            student.setGraduation(false);
            String defaultPassword = student.getIdCard().substring(12,18);
            student.setPassword(defaultPassword);

            try{
                studentMapper.insertStudent(student);
            }catch (Exception ex){
                ex.printStackTrace();
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean importCourseByExcel(){
        // TODO

        return true;
    }

    @Override
    public boolean importTeacherByExcel(String filePath){
        // 获取Workbook
        Workbook workbook = ExcelUitl.getWorkbook(filePath);
        if(workbook == null) return false;

        Sheet sheet = workbook.getSheetAt(0);
        int begin = sheet.getFirstRowNum()+1;
        int end = sheet.getLastRowNum();
        for(int i = begin;i <= end;i++){
            Row row = sheet.getRow(i);
            Teacher teacher = new Teacher();
            if(row == null) continue;

            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);

            teacher.setTeacherId(nf.format(row.getCell(0).getNumericCellValue()));
            teacher.setTeacherName(row.getCell(1).getStringCellValue());
            teacher.setIdCard(row.getCell(5).getStringCellValue());

            // 3种教师类型判定y为true，n为false
            String flags = "";
            for(int j = 2;j < 5;j++){
                flags += row.getCell(j).getStringCellValue();
            }
            teacher.setTeacherType(flags.charAt(0) == 'y');
            teacher.setLeaderType(flags.charAt(1) == 'y');
            teacher.setMonitorType(flags.charAt(2) == 'y');

            // 补充属性
            String defaultPassword = teacher.getIdCard().substring(12,18);
            teacher.setPassword(defaultPassword);
            Date initDate = new Date(0);
            teacher.setLastLoginTime(initDate);

            try{
                teacherMapper.insertTeacher(teacher);
            }catch (Exception ex){
                ex.printStackTrace();
                return false;
            }
        }

        return true;
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
