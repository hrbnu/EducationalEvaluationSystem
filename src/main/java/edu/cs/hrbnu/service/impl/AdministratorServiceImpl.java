package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.StudentMapper;
import edu.cs.hrbnu.model.Administrator;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.AdministratorService;
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
import java.util.HashMap;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    StudentMapper studentMapper;

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
        // TODO ing
        File file = new File(filePath);
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(file);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        // 看是xls格式还是xlsx格式
        char species = filePath.charAt(filePath.length()-1);
        Workbook workbook = null;
        try{
            if(species == 's'){
                workbook = new HSSFWorkbook(inputStream);
            }else{
                workbook = new XSSFWorkbook(inputStream);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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
    public boolean importTeacherByExcel(){
        // TODO

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
