package edu.cs.hrbnu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cs.hrbnu.model.Weight;
import edu.cs.hrbnu.service.AdministratorService;

@Controller
@RequestMapping("modify")
public class UpdateGradingController {
	@Autowired
	AdministratorService administratorService;
	double studentWeight;
	double teacherWeight;
	double leaderWeight;
	double myselfWeight;
	
	@RequestMapping("update")
	public ModelAndView update(Weight weight, Model model){
		administratorService.updateGrading(weight);
//		System.out.println(studentWeight);
//		System.out.println(teacherWeight);
//		System.out.println(leaderWeight);
//		System.out.println(myselfWeight);
        model.addAttribute("flag",true);
        return  new ModelAndView("administrator/modify");
	}
}
