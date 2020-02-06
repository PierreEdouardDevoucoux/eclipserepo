package com.springdemo.controllers.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demos.errors.ErrorResponse;
import com.springdemo.entities.Student;
import com.springdemo.exception.StudentNotFoundException;
import com.springdemo.services.WebServiceService;

@RequestMapping("/api")
@RestController
public class WebServiceController {

	@Autowired
	WebServiceService service;
	
	@GetMapping("/students")
	public List<Student> afficherPage2()
	{
		List<Student> listStudent= service.callgetStudents();
		return listStudent;
	}
	
	@GetMapping("/student/id/{studentid}")
    public Student message(@PathVariable String studentid) {
		try
		{
			Integer.parseInt(studentid);
		}
		catch(NumberFormatException ex)
		{
			throw new NumberFormatException();
		}
        Student stu = service.callgetStudent(Integer.parseInt(studentid));
        if (stu == null)
            throw new StudentNotFoundException();
        stu.setCours(null);
        return stu;
    }
	
	@GetMapping("/students/first_name/{first_name}")
    public List<Student> message1(@PathVariable String first_name) {
		List<Student> lstu = service.callgetStudents("first_name", first_name);
        return lstu;
    }
	
	@DeleteMapping("/students/delete/id/{studentid}")
    public void message2(@PathVariable String studentid) {
		Student s = service.callgetStudent(Integer.parseInt(studentid));
        service.calldeleteStudent(s);
    }
	
	@PostMapping(value="/student/add/")
    public void message3(@RequestBody Student s) {
        service.callinsertStudent(s);
    }
	
	@PutMapping(value="/student/put/{id}")
    public void message4(@RequestBody Student s, @PathVariable int id) {
		s.setId(id);
        service.callupdateStudent(s);
    }	
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
