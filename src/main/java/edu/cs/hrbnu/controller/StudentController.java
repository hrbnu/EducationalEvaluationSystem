package edu.cs.hrbnu.controller;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.EvaluateProblem;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/eval")
    public ModelAndView evaluation(Model model, Student student, Course course) {
        List<EvaluateProblem> listEvaluateProblem = studentService.evaluateCurrentCourse(student.getStudentId(), course.getCourseId());
        model.addAttribute("listEvaluateProblem", listEvaluateProblem);
        return new ModelAndView("evalu/evalu");
    }

}
