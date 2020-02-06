package com.springdemo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.daos.CoursDao;
import com.springdemo.entities.Course;
import com.springdemo.services.StudentInstructorService;

@RequestMapping("/cours/")
@Controller
public class CoursController {

	@Autowired
	StudentInstructorService service;
	
	@RequestMapping("/")
	public String afficherPage1()
	{
		return "accueil";
	}
	
	@Valid
	@RequestMapping("/cou_liste")
	public String afficherPage2(Model m,Course s, HttpServletRequest srequest)
	{
		if(srequest.getParameter("option") != null)
		{
			service.calldeleteCours(s);
		}
		List<Course> listCours= service.callgetCourss();
		
		m.addAttribute("listCours", listCours);
	    return "cours/cou_liste";
	}
	
	@Valid
	@RequestMapping("/cou_update")
	public String afficherPage3(Model m,@Valid@ModelAttribute Course s, BindingResult bd, HttpServletRequest srequest, HttpServletResponse sresponse) throws IOException
	{		
		System.out.println("laor");
		if(srequest.getParameter("option") != null)
		{
			System.out.println("de");
			if(bd.hasErrors())
				return "cours/cou_update";
			else
			{
				System.out.println(srequest.getParameter("option"));
				if(srequest.getParameter("option").equals("U"))
				{
					System.out.println("save");
					service.callupdateCours(s);
					sresponse.sendRedirect ("cou_liste");
				}
				else
				{
					if(srequest.getParameter("option").equals("L"))
					{
						s = service.callgetCours(Integer.parseInt(srequest.getParameter("id")));
					}
				}
				
			}
		}
		m.addAttribute("cours", s);
	    return "cours/cou_update";
	    	
	}
	
	@Valid
	@RequestMapping("/cou_create")
	public String afficherPage4(Model m,@Valid@ModelAttribute Course s, BindingResult bd, HttpServletRequest srequest, HttpServletResponse sresponse) throws IOException
	{		
		System.out.println("TOTO");
		if(srequest.getParameter("option") != null)
		{
			if(bd.hasErrors())
				return "cours/cou_create";
			else
			{
				service.callinsertCours(s);
				sresponse.sendRedirect ("cou_liste");
			}
		}
	    return "cours/cou_create";
	    	
	}
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
