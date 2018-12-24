package edu.cs.hrbnu.service.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import edu.cs.hrbnu.DAO.*;
import edu.cs.hrbnu.model.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.cs.hrbnu.service.AdministratorService;
import edu.cs.hrbnu.uitl.ExcelUitl;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
	@Autowired
    AdministratorMapper administratorMapper;
	@Autowired
	EvaluateProblemMapper evaluateProblemMapper;

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
	@Autowired
	EvaluateMapper evaluateMapper;
	@Autowired
	ComplaintMapper complaintMapper;

	@Override
	public Administrator login(Administrator administrator){

		Administrator admin = null;
		try {
			admin =  administratorMapper.getAdministrator(administrator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
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

        // 匹配表头，必须与格式相同，否则不允许导入
        boolean flag = true;
        Row firstRow = sheet.getRow(sheet.getFirstRowNum());
        if(firstRow.getLastCellNum() != 6){
            flag = false;
        }else{
            if("学号".compareTo(firstRow.getCell(0).getStringCellValue()) != 0) flag = false;
            if("班级".compareTo(firstRow.getCell(1).getStringCellValue()) != 0) flag = false;
            if("身份证号".compareTo(firstRow.getCell(2).getStringCellValue()) != 0) flag = false;
            if("姓名".compareTo(firstRow.getCell(3).getStringCellValue()) != 0) flag = false;
            if("年级".compareTo(firstRow.getCell(4).getStringCellValue()) != 0) flag = false;
            if("专业".compareTo(firstRow.getCell(5).getStringCellValue()) != 0) flag = false;
        }
        if(!flag) return false;

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
    public boolean importCourseByExcel(String filePath){
        Workbook workbook = ExcelUitl.getWorkbook(filePath);
        if(workbook == null) return false;

        Sheet sheet = workbook.getSheetAt(0);

        boolean flag = true;
        Row firstRow = sheet.getRow(sheet.getFirstRowNum());
        if(firstRow.getLastCellNum() != 9){
            flag = false;
        }else{
            if("课程编号".compareTo(firstRow.getCell(0).getStringCellValue()) != 0) flag = false;
            if("课程名".compareTo(firstRow.getCell(1).getStringCellValue()) != 0) flag = false;
            if("教师编号".compareTo(firstRow.getCell(2).getStringCellValue()) != 0) flag = false;
            if("所属学期".compareTo(firstRow.getCell(3).getStringCellValue()) != 0) flag = false;
            if("课程属性".compareTo(firstRow.getCell(4).getStringCellValue()) != 0) flag = false;
            if("上课班级".compareTo(firstRow.getCell(5).getStringCellValue()) != 0) flag = false;
            if("开始周".compareTo(firstRow.getCell(6).getStringCellValue()) != 0) flag = false;
            if("结束周".compareTo(firstRow.getCell(7).getStringCellValue()) != 0) flag = false;
            if("总学时".compareTo(firstRow.getCell(8).getStringCellValue()) != 0) flag = false;
        }
        if(!flag) return false;

        int begin = sheet.getFirstRowNum()+1;
        int end = sheet.getLastRowNum();
        for(int i = begin;i <= end;i++){
            Row row = sheet.getRow(i);
            Course course = new Course();
            if(row == null) continue;

            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);

            course.setCourseId(nf.format(row.getCell(0).getNumericCellValue()));
            course.setCourseName(row.getCell(1).getStringCellValue());
            course.setTeacherId(nf.format(row.getCell(2).getNumericCellValue()));
            course.setSemester(Integer.parseInt(nf.format(row.getCell(3).getNumericCellValue())));
            course.setClassification(nf.format(row.getCell(4).getNumericCellValue()));

            // 班级这里有点疑问：例如3、4班的课程一样，是否需要对班级也设置成主键？
            course.setCourseClass(nf.format(row.getCell(5).getNumericCellValue()));

            course.setStartTime(nf.format(row.getCell(6).getNumericCellValue()));
            course.setEndTime(nf.format(row.getCell(7).getNumericCellValue()));
            course.setLearnTime(Integer.parseInt(nf.format(row.getCell(8).getNumericCellValue())));

            try{
                courseMapper.insertCourse(course);
            }catch (Exception ex){
                ex.printStackTrace();
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean importTeacherByExcel(String filePath){
        // 获取Workbook
        Workbook workbook = ExcelUitl.getWorkbook(filePath);
        if(workbook == null) return false;

        Sheet sheet = workbook.getSheetAt(0);

        boolean flag = true;
        Row firstRow = sheet.getRow(sheet.getFirstRowNum());
        if(firstRow.getLastCellNum() != 6){
            flag = false;
        }else{
            if("工号".compareTo(firstRow.getCell(0).getStringCellValue()) != 0) flag = false;
            if("姓名".compareTo(firstRow.getCell(1).getStringCellValue()) != 0) flag = false;
            if("是否为教师".compareTo(firstRow.getCell(2).getStringCellValue()) != 0) flag = false;
            if("是否为领导".compareTo(firstRow.getCell(3).getStringCellValue()) != 0) flag = false;
            if("是否为督导".compareTo(firstRow.getCell(4).getStringCellValue()) != 0) flag = false;
            if("身份证号码".compareTo(firstRow.getCell(5).getStringCellValue()) != 0) flag = false;
        }
        if(!flag) return false;

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

	//增加学生信息  学生课程通过查询同班同学的课程进行添加
	//Student、StudentCourse(根据同年级同专业同班同学导入课程)、
	@Override
	public boolean insertStudent(Student student){
		boolean isSuccess = true;
		try {
			//判断学号是否已经存在
			Student studentJudge = studentMapper.getStudentById(student.getStudentId());
			if(studentJudge != null){
				isSuccess = false;
			} else {
				//存Student表
				//学生学登录密码、是否毕业标志系统设置
				student.setPassword(student.getIdCard().substring(12));
				student.setGraduation(false);
				studentMapper.insertSingleStudentInfo(student);
				//存student_course表
				HashMap<String,Object> map = new HashMap<String, Object>();
				map.put("department",student.getDepartment());
				map.put("grade",student.getGrade());
				map.put("classId",student.getClassId());
				//获取一个同班同学学号
				String classmateId = studentMapper.selectClassmateInfo(map);
				//根据同班同学学号获取student_course表中所有的课号
				HashMap<String,Object> courseMap = new HashMap<String, Object>();
				courseMap.put("studentId",classmateId);
				courseMap.put("history",false);
				List<String> courseIds = studentCourseMapper.selectCourseIdsByClassmateId(courseMap);
				//插入所有课程
				//studentId,courseId,courseTime=0,history=false
				List<StudentCourse> studentCourseList = new ArrayList<StudentCourse>();
				for(String courseId:courseIds){
					StudentCourse studentCourse = new StudentCourse();
					studentCourse.setStudentId(student.getStudentId());
					studentCourse.setCourseId(courseId);
					studentCourse.setCourseTime(0);
					studentCourse.setHistory(false);
					studentCourseList.add(studentCourse);
				}
				studentCourseMapper.insertSingleStudentCourses(studentCourseList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	//学生所有信息都可以修改
	@Override
	public void updateSingleStudent(Student student,String oldStudentId){
		try {
			if(!student.getStudentId().equals(oldStudentId)){
				//修改student_course(studentId)
				HashMap<String,Object> studentIdMap = new HashMap<String, Object>();
				studentIdMap.put("studentId",student.getStudentId());
				studentIdMap.put("oldStudentId",oldStudentId);
				//修改evaluate(flagId)
				evaluateMapper.updateFlagIdByStudentId(studentIdMap);
			}
			HashMap<String,Object> studentMap = new HashMap<String, Object>();
			studentMap.put("student",student);
			studentMap.put("oldStudentId",oldStudentId);
			studentMapper.updateSingleStudent(studentMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//删除单条学生信息 complaint表关联student
	//删除complaint(ref studentId)、student(studentId)、studentCourse(studentId)、evaluate(flagId)
	@Override
	public void deleteSingleStudent(String studentId){
		try {
//            complaintMapper.deleteSingleStudentComplaints(studentId);
//            studentCourseMapper.deleteSingleStudentCourses(studentId);
			evaluateMapper.deleteSingleStudentEvaluates(studentId);
			studentMapper.deleteSingleStudent(studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
    	
    	double studentEvaluateScore = 0.5;
		double teacherEvaluateScore = 0.5;
		double leaderEvaluateScore = 0.5;
		double myselfEvaluateScore = 0.5;
		DecimalFormat dFormat = new DecimalFormat("###.##");
    	if(weight==null){
 //   		System.out.println("空的");
    		//使用默认权值
    		//获取到课程的各类人的总评分
    		
    		//因为.properties文件中存放的都是String类型，所以要进行类型转换
    		studentweight = Double.parseDouble(studentWeight);
    		teacherweight = Double.parseDouble(teacherWeight);
    		leaderweight = Double.parseDouble(leaderWeight);
    		myselfweight = Double.parseDouble(myselfWeight);
    		try {
    			//得到所有的课程
    			List<Course> lists = courseMapper.getAllCourses();
    			List<StudentCourse> studentLists=null;
    			List<Evaluate> teacherEvaluateLists=null;
    			List<Evaluate> leaderEvaluateLists=null;
    			//得到学生评价的最后的分
    			for (Course course : lists) {
    				double finallyScore=0;
    		    	double studentnum=0;
    		    	double teachernum=0;
    		    	double leadernum=0;
    				//得到所有学生的Id
    				studentLists = studentCourseMapper.getStudentIdByCourseId(course.getCourseId());
    				if (studentLists.isEmpty()) {
						studentEvaluateScore=100;
						studentnum=1;
					}
    				//得到学生评价的分
    				for (StudentCourse studentCourse : studentLists) {
						List<Evaluate> evaluates = evaluateMapper.getEvaluateScoreByStudentIdAndCourseId(studentCourse.getStudentId(), course.getCourseId());
						//如果一个学生也没评价  就默认都是满分100
						if(evaluates.isEmpty()){
							studentEvaluateScore=studentLists.size()*100;
							studentnum=studentLists.size();
						}
						else {
							double score=0;
	    					double num=0;
							for (Evaluate evaluate : evaluates) {
								//如果有学生没评价 默认100
								if (evaluate==null) {
									score+=100;
									num++;
								} 
								else {
									score+=evaluate.getEvaluateScore();
									num++;	
								}
							}
							studentEvaluateScore+=(score/num);
							studentnum++;
						}
					}
        			//得到同行评价的分
        			teacherEvaluateLists=evaluateMapper.getEealuateScoreByCourseIdAndFlag(course.getCourseId(), "2");
        			if(teacherEvaluateLists.isEmpty()){
        				//如果没有同行评价，就给一个默认100
        				teacherEvaluateScore+=100;
        				teachernum++;
        			}
        			else {
        				//有老师评价
        				for (Evaluate evaluate : teacherEvaluateLists) {
    						teacherEvaluateScore+=evaluate.getEvaluateScore();
    						teachernum++;
    					}
					}
        			//得到督导评价的分
        			leaderEvaluateLists=evaluateMapper.getEealuateScoreByCourseIdAndFlag(course.getCourseId(), "3");
        			if (leaderEvaluateLists.isEmpty()) {
						//如果没有督导评价  默认给一个
        				leaderEvaluateScore+=100;
        				leadernum++;
        				
					} else {
						for (Evaluate evaluate : leaderEvaluateLists) {
							leaderEvaluateScore+=evaluate.getEvaluateScore();
							leadernum++;
						}
					}
        			//得到自评的分
        			Teacher teacher = teacherMapper.getMyselfEvaluateScoreByCourseId(course.getCourseId());
        			if(teacher==null){
        				teacherEvaluateScore=100;
        			}
        			else {
        				myselfEvaluateScore=teacher.getMyselfEvaluateScore();
					}
        			myselfEvaluateScore=myselfEvaluateScore/(100);
        			leaderEvaluateScore=leaderEvaluateScore/(100*leadernum);
        			teacherEvaluateScore=teacherEvaluateScore/(100*teachernum);
        			studentEvaluateScore=studentEvaluateScore/(100*studentnum);
        			//给每一个课程计算最后的评分
    				finallyScore=(studentEvaluateScore*studentweight+teacherEvaluateScore*teacherweight+leaderEvaluateScore*leaderweight+myselfEvaluateScore*myselfweight)*100;
    				finallyScore=Double.parseDouble(dFormat.format(finallyScore));
    				int i = courseMapper.updateCourseScoreByCourseId(course.getCourseId(), finallyScore);	
    			}

    			
    			
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	else {
	    	//得到权值
	    	studentweight=(weight.getStudentWeight())/100;
			teacherweight=(weight.getTeacherWeight())/100;
			leaderweight=(weight.getLeaderWeight())/100;
			myselfweight=(weight.getMyselfWeight())/100;
			try {
    			//得到所有的课程
    			List<Course> lists = courseMapper.getAllCourses();
    			List<StudentCourse> studentLists=null;
    			List<Evaluate> teacherEvaluateLists=null;
    			List<Evaluate> leaderEvaluateLists=null;
    			//得到学生评价的最后的分
    			for (Course course : lists) {
    				double finallyScore=0;
    		    	double studentnum=0;
    		    	double teachernum=0;
    		    	double leadernum=0;
    				//得到所有学生的Id
    				studentLists = studentCourseMapper.getStudentIdByCourseId(course.getCourseId());
    				if (studentLists.isEmpty()) {
						studentEvaluateScore=100;
						studentnum=1;
					}
    				//得到学生评价的分
    				for (StudentCourse studentCourse : studentLists) {
						List<Evaluate> evaluates = evaluateMapper.getEvaluateScoreByStudentIdAndCourseId(studentCourse.getStudentId(), course.getCourseId());
						//如果一个学生也没评价  就默认都是满分100
						if(evaluates.isEmpty()){
							studentEvaluateScore=studentLists.size()*100;
							studentnum=studentLists.size();
						}
						else {
							double score=0;
	    					double num=0;
							for (Evaluate evaluate : evaluates) {
								//如果有学生没评价 默认100
								if (evaluate==null) {
									score+=100;
									num++;
								} 
								else {
									score+=evaluate.getEvaluateScore();
									num++;	
								}
							}
							studentEvaluateScore+=(score/num);
							studentnum++;
						}
					}
        			//得到同行评价的分
        			teacherEvaluateLists=evaluateMapper.getEealuateScoreByCourseIdAndFlag(course.getCourseId(), "2");
        			if(teacherEvaluateLists.isEmpty()){
        				//如果没有同行评价，就给一个默认100
        				teacherEvaluateScore+=100;
        				teachernum++;
        			}
        			else {
        				//有老师评价
        				for (Evaluate evaluate : teacherEvaluateLists) {
    						teacherEvaluateScore+=evaluate.getEvaluateScore();
    						teachernum++;
    					}
					}
        			//得到督导评价的分
        			leaderEvaluateLists=evaluateMapper.getEealuateScoreByCourseIdAndFlag(course.getCourseId(), "3");
        			if (leaderEvaluateLists.isEmpty()) {
						//如果没有督导评价  默认给一个
        				leaderEvaluateScore+=100;
        				leadernum++;
        				
					} else {
						for (Evaluate evaluate : leaderEvaluateLists) {
							leaderEvaluateScore+=evaluate.getEvaluateScore();
							leadernum++;
						}
					}
        			//得到自评的分
        			Teacher teacher = teacherMapper.getMyselfEvaluateScoreByCourseId(course.getCourseId());
        			if(teacher==null){
        				teacherEvaluateScore=100;
        			}
        			else {
        				myselfEvaluateScore=teacher.getMyselfEvaluateScore();
					}
        			myselfEvaluateScore=myselfEvaluateScore/(100);
        			leaderEvaluateScore=leaderEvaluateScore/(100*leadernum);
        			teacherEvaluateScore=teacherEvaluateScore/(100*teachernum);
        			studentEvaluateScore=studentEvaluateScore/(100*studentnum);
        			//给每一个课程计算最后的评分
    				finallyScore=(studentEvaluateScore*studentweight+teacherEvaluateScore*teacherweight+leaderEvaluateScore*leaderweight+myselfEvaluateScore*myselfweight)*100;
    				finallyScore=Double.parseDouble(dFormat.format(finallyScore));
    				int i = courseMapper.updateCourseScoreByCourseId(course.getCourseId(), finallyScore);	
    			}

    			
    			
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
   }

	//增加教师信息
	@Override
	public boolean insertTeacher(Teacher teacher){
		boolean isSuccess = true;
		try {
			//判断教师工号是否已经存在
			Teacher teacherJudge = teacherMapper.getTeacherById(teacher.getTeacherId());
			if(teacherJudge != null){
				isSuccess = false;
			}
			teacher.setPassword(teacher.getIdCard().substring(12));
			teacherMapper.insertSingleTeacherInfo(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}


	@Override
	public void updateSingleTeacher(Teacher teacher,String oldTeacherId){
		try {
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("teacher",teacher);
			map.put("oldTeacherId",oldTeacherId);
			//修改evaluate表中的flagId
			HashMap<String,Object> evaluateMap = new HashMap<String, Object>();
			evaluateMap.put("teacherId",teacher.getTeacherId());
			evaluateMap.put("oldTeacherId",oldTeacherId);
			evaluateMapper.updateFlagIdByTeacherId(evaluateMap);
			//修改teacher表信息
			teacherMapper.updateSingleTeacher(map);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//删除单条教师信息
	//删除course(teacherId)删除前先获得课程号courseId、
	//student_course(courseId主键)、complaint(courseId关联)、evaluate(flagId)
	@Override
	public void deleteSingleTeacher(String teacherId){
		try {
			//获得所有课程号
			List<String> courseIds = courseMapper.selectCourseIdsByTeacherId(teacherId);
			for(String courseId:courseIds){
				//删除complaint(courseId)
				complaintMapper.deleteComplaintsByCourseId(courseId);
				//删除evaluate(courseId)
				evaluateMapper.deleteEvaluatesByCourseId(courseId);
				//删除student_course(courseId)
				studentCourseMapper.deleteStudentCoursesByCourseId(courseId);
			}
			//删除course(teacherId)
			courseMapper.deleteCoursesByTeacherId(teacherId);
			//删除teacher(teacherId)
			teacherMapper.deleteSingleTeacher(teacherId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//查询所有学生信息
	@Override
	public List<Student> selectAllStudentInfo(){
		List<Student> studentsInfo = new ArrayList<Student>();
		try {
			studentsInfo = studentMapper.selectAllStudentInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentsInfo;
	}

	//查询单条学生信息
	public Student selectSingleStudentInfo(String studentId){
		Student student = new Student();
		try {
			student = studentMapper.selectSingleStudentInfo(studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	//查询所有学生总数
	public int selectStudentCount(){
		int count = 0;
		try {
			count = studentMapper.selectStudentCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//按条件查询在校学生总数
	@Override
	public int selectStudentCountByCondition(String department,int grade,int classId){
		int count = 0;
		try {
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("department",department);
			map.put("grade",grade);
			map.put("classId",classId);
			count = studentMapper.selectStudentCountByCondition(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//按条件查询在校学生
	public List<Student> selectStudentByCondition(String department,int grade,int classId){
		List<Student> studentsInfo = new ArrayList<Student>();
		try {
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("department",department);
			map.put("grade",grade);
			map.put("classId",classId);
			studentsInfo = studentMapper.selectStudentByCondition(map);
		}catch (Exception e){
			e.printStackTrace();
		}
		return studentsInfo;
	}

	//按条件查询已毕业学生总数
	@Override
	public int selectGraduatedStudentCountByCondition(String department,boolean isGraduation,int classId){
		int count = 0;
		try {
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("department",department);
			map.put("graduation",isGraduation);
			map.put("classId",classId);
			count = studentMapper.selectGraduatedStudentCountByCondition(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//按条件查询已毕业学生
	public List<Student> selectGraduatedStudentByCondition(String department,boolean isGraduation,int classId){
		List<Student> studentsInfo = new ArrayList<Student>();
		try {
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("department",department);
			map.put("graduation",isGraduation);
			map.put("classId",classId);
			studentsInfo = studentMapper.selectGraduatedStudentByCondition(map);
		}catch (Exception e){
			e.printStackTrace();
		}
		return studentsInfo;
	}


	//查询所有教师信息
	@Override
	public List<Teacher> selectAllTeacherInfo(){
		List<Teacher> teachersInfo = new ArrayList<Teacher>();
		try {
			teachersInfo = teacherMapper.selectAllTeacherInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachersInfo;
	}

	//查询所有教师总数
	public int selectTeacherCount(){
		int count = 0;
		try {
			count = teacherMapper.selectTeacherCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//按条件查询教师总数
	@Override
	public int selectTeacherCountByCondition(Teacher teacher){
		int count = 0;
		try {
			count = teacherMapper.selectTeacherCountByCondition(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//按条件查询教师
	public List<Teacher> selectTeacherByCondition(Teacher teacher){
		List<Teacher> teachersInfo = new ArrayList<Teacher>();
		try {
			teachersInfo = teacherMapper.selectTeacherByCondition(teacher);
		}catch (Exception e){
			e.printStackTrace();
		}
		return teachersInfo;
	}

	//查询单条教师信息
	public Teacher selectSingleTeacherInfo(String teacherId){
		Teacher teacher = new Teacher();
		try {
			teacher = teacherMapper.selectSingleTeacherInfo(teacherId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;
	}

	/**
	 * 单条插入课程信息
	 */
	@Override
	public boolean insertSingleCourse(Course course){
		boolean isSuccess = true;
		try {
			//判断课程信息是否已存在
			Course courseJudge = courseMapper.getCourseById(course.getCourseId());
			if(courseJudge != null){
				isSuccess = false;
			} else {
				//1.插入course
				courseMapper.insertSingleCourse(course);
				//获取学生信息
				//2.通过课程号前四位获取年级
				String grade = course.getCourseId().substring(0,4);
				HashMap<String,Object> map = new HashMap<String, Object>();
				map.put("grade",grade);
				map.put("classId",course.getCourseClass());
				List<String> studentLists = null;
				studentLists = studentMapper.selectStudentIdsByGradeAndClassId(map);
				//3.插入student_course
				List<StudentCourse> studentCourseList = new ArrayList<StudentCourse>();
				for(String studentId:studentLists){
					StudentCourse studentCourse = new StudentCourse();
					studentCourse.setStudentId(studentId);
					studentCourse.setCourseId(course.getCourseId());
					studentCourse.setHistory(false);
					studentCourse.setCourseTime(0);
					studentCourseList.add(studentCourse);
				}
				studentCourseMapper.insertStudentCourses(studentCourseList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public List<EvaluateProblem> getAllEvaluateProblems(){
		List<EvaluateProblem> problemList= null;
		try {
			problemList=evaluateProblemMapper.getAllEvaluateProblem();
		}catch (Exception e){
			e.printStackTrace();
		}
		return problemList;

	}

	@Override
	public void addProblem(EvaluateProblem  problem){
		try {
			evaluateProblemMapper.addEvaluateProblem(problem.getEvaluateProblemContent(),problem.getForWho(),problem.getScore());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void alterProblem(int id,String context){
		try{
			evaluateProblemMapper.alterProblem(id,context);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
