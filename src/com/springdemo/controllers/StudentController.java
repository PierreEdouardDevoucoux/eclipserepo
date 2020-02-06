package com.springdemo.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.Session;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mysql.cj.jdbc.Blob;
import com.springdemo.daos.StudentDao;
import com.springdemo.entities.Course;
import com.springdemo.entities.Student;
import com.springdemo.services.StudentInstructorService;

@RequestMapping("/student/")
@Controller
public class StudentController {

	@Autowired
	StudentInstructorService service;
	
	@RequestMapping("/")
	public String afficherPage1()
	{
		return "accueil";
	}
	
	@Valid
	@RequestMapping("/stu_liste")
	public String afficherPage2(Model m,Student s, HttpServletRequest srequest)
	{
		List<Student> listStudent;
		listStudent= service.callgetStudents();
		
		if(srequest.getParameter("option") != null)
		{
			if(srequest.getParameter("option").equals("D"))
			{
				service.calldeleteStudent(s);
			}
			else
			{
				if(srequest.getParameter("option").equals("S"))
				{
					listStudent= service.callgetStudents(srequest.getParameter("searchattribut"),srequest.getParameter("searchvalue"));
				}
			}
			
		}
		m.addAttribute("listStudent", listStudent);
		String encodeBase64 = convertBinImageToString(s.getPhoto()); 
	    String photoencodeBase64 = new String(encodeBase64);
	    m.addAttribute("image", photoencodeBase64);
	    return "student/stu_liste";
	    	
	}
	
	public static String convertBinImageToString(byte[] binImage) {
        if(binImage!=null && binImage.length>0) {
            return Base64.getEncoder().encodeToString(binImage);
        }
        else
            return "";
    }
	
	@Valid
	@RequestMapping("/stu_update")
	public String afficherPage3(Model m,@Valid@ModelAttribute Student s, BindingResult bd, HttpServletRequest srequest, HttpServletResponse sresponse) throws IOException
	{		
		if(srequest.getParameter("option") != null)
		{
			if(bd.hasErrors())
				return "student/stu_update";
			else
			{
				if(srequest.getParameter("option").equals("U"))
				{
					service.callupdateStudent(s);
					sresponse.sendRedirect ("stu_liste");
				}
				else
				{
					if(srequest.getParameter("option").equals("L"))
					{
						s = service.callgetStudent(Integer.parseInt(srequest.getParameter("id")));
					}
					else
					{
						if(srequest.getParameter("option").equals("A"))
						{
							Course cour = service.callgetCours(Integer.parseInt(srequest.getParameter("coursid"))); 
							s.addCours(cour);
							service.callupdateStudent(s);
						}
					}
				}
				
			}
		}
		m.addAttribute("student", s);
		
		List<Course> listeCours= service.callgetCourss();
		
		m.addAttribute("listCours", listeCours);
	    return "student/stu_update";
	    	
	}
	
	@Valid
	@RequestMapping("/stu_create")
	public String afficherPage4(Model m,@Valid@ModelAttribute Student s, BindingResult bd, HttpServletRequest srequest, HttpServletResponse sresponse) throws IOException
	{		
		System.out.println("TOTO");
		if(srequest.getParameter("option") != null)
		{
			if(bd.hasErrors())
				return "student/stu_create";
			else
			{
				service.callinsertStudent(s);
					sresponse.sendRedirect ("stu_liste");
			}
		}
	    return "student/stu_create";
	    	
	}
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
