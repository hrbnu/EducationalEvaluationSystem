package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.CourseMapper;
import edu.cs.hrbnu.DAO.StudentCourseMapper;
import edu.cs.hrbnu.DAO.StudentMapper;
import edu.cs.hrbnu.model.Administrator;
import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.model.Weight;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    StudentMapper studentMapper;
    
	@Value("${studentWeight}")
	private String studentWeight;
	@Value("${teacherWeight}")
	private String teacherWeight;
	@Value("${leaderWeight}")
	private String leaderWeight;
	@Value("${myselfWeight}")
	private String myselfWeight;
	
	private double studentweight;
	private double teacherweight;
	private double leaderweight; 
	private double myselfweight; 
	@Autowired
	ServletContext context;
	
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	StudentCourseMapper studentCourseMapper;

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
    public void updateGrading(Weight weight){
        // TODO
    	//将权值保存到Application上下文中
    	//问题是当服务器关闭时会出现问题
    	//解决方法   创建config.property  添加默认的权值
    	context.setAttribute("weight", weight);
    }

    @Override
    public void generalComment(Weight weight){
        // TODO
    	
    	
    	/*
    	 * 思路：
    	 * 学生的分：从course表中获得courseId，根据ID从student_course表中得到所有上这们课的学生的ID，然后从evaluate表中得到评价的分
    	 * 		相加的和/(100(满分100)*学生的数量)=studentEvaluateScore
    	 * 同行的分：从course表中获得courseId，根据ID从evaluate中根据flag=2来判断是同行评价
    	 * 		相加的和/(100*评价的老师的数量)=teacherEvaluateScore
    	 * 督导的分：从course表中获得courseId，根据ID从evaluate中根据flag=3来判断是督导评价
    	 *		相加的和/(100*评价的督导的数量)=leaderEvaluateScore
    	 * 自评的分：分/100=myselfEvaluateScore
    	 * 
    	 * */
    	double finallyScore=0;
    	if(weight==null){
 //   		System.out.println("空的");
    		//使用默认权值
    		//获取到课程的各类人的总评分
    		double studentEvaluateScore = 0.5;
    		double teacherEvaluateScore = 0.5;
    		double leaderEvaluateScore = 0.5;
    		double myselfEvaluateScore = 0.5;
    		//因为.properties文件中存放的都是String类型，所以要进行类型转换
    		studentweight = Double.parseDouble(studentWeight);
    		teacherweight = Double.parseDouble(teacherWeight);
    		leaderweight = Double.parseDouble(leaderWeight);
    		myselfweight = Double.parseDouble(myselfWeight);
    		try {
    			//得到所有的课程
    			List<Course> lists = courseMapper.getAllCourses();
    			
    			//得到学生评价的最后的分
    			for (Course course : lists) {
    				//得到所有学生的Id
					List<Student> studentLists = studentCourseMapper.getStudentIdByCourseId(course.getCourseId());
				}
    			
    			//给每一个课程计算最后的评分
    			for (Course course : lists) {
    				String courseId =course.getCourseId();
    				finallyScore=(studentEvaluateScore*studentweight+teacherEvaluateScore*teacherweight+leaderEvaluateScore*leaderweight+myselfEvaluateScore*myselfweight)*100;
    				int i = courseMapper.updateCourseScoreByCourseId(courseId, finallyScore);
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	else {
//			System.out.println("非空");
	    	//得到权值
	    	studentweight=weight.getStudentWeight();
			teacherweight=weight.getTeacherWeight();
			leaderweight=weight.getLeaderWeight();
			myselfweight=weight.getMyselfWeight();
			//获取到课程的各类人的总评分
			double studentEvaluateScore = 0.6;
			double teacherEvaluateScore = 0.6;
			double leaderEvaluateScore = 0.6;
			double myselfEvaluateScore = 0.6;
			try {
				List<Course> lists = courseMapper.getAllCourses();
				for (Course course : lists) {
					String courseId =course.getCourseId();
					finallyScore=(studentEvaluateScore*studentweight+teacherEvaluateScore*teacherweight+leaderEvaluateScore*leaderweight+myselfEvaluateScore*myselfweight)*100;
					int i = courseMapper.updateCourseScoreByCourseId(courseId, finallyScore);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
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
