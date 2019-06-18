package com.ssi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.StudentDAO;
import com.ssi.entities.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value="savestudent",method=RequestMethod.POST)
	public ModelAndView addStudentData(@ModelAttribute("student") Student student){
		studentDAO.addStudent(student);
		ModelAndView mv=new ModelAndView("saveconfirm");
		return mv;
	}
	@RequestMapping("newstudent")
	public String showEntryForm(){
		return "dataentry";
	}
	
}
