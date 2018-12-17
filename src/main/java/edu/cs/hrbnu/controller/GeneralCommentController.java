package edu.cs.hrbnu.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cs.hrbnu.model.Weight;
import edu.cs.hrbnu.service.AdministratorService;
@Controller
@RequestMapping("/general")
public class GeneralCommentController {
	@Autowired
	AdministratorService administratorService;
	@Autowired
	ServletContext context;
	
	@RequestMapping("/comment")
	public ModelAndView gengeal() {
		Weight weight = (Weight) context.getAttribute("weight");
		administratorService.generalComment(weight);
		return  new ModelAndView("Modify");
	}
}
