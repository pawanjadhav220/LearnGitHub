package com.my.course.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.course.entity.Course;
import com.my.course.response.ResponseCourse;
import com.my.course.service.CourseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Main")
public class CourseController {
	
	@Autowired
	CourseService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseCourse> create(@RequestBody Course c)
	{ 
		Course cs=service.addCourse(c);
		if (cs != null) {
			return new ResponseEntity<ResponseCourse>( new ResponseCourse("ok","sucess",cs,null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<ResponseCourse>( new ResponseCourse("Fail","Fail",cs,null), HttpStatus.BAD_REQUEST);

		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseCourse>  getCourses(@PathVariable int id)
	{
		System.out.println("Called");
		 Course find = service.findById(id);
		 if (find!=null) {
			 return new ResponseEntity<ResponseCourse>(new ResponseCourse("OK","found", find, null),HttpStatus.ACCEPTED);

		}
		 return new ResponseEntity<ResponseCourse>(new ResponseCourse("OK","found", null, null),HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/All")
	public ResponseEntity<ResponseCourse>  getAllCourses()
	{
		System.out.println("Called");
		 List<Course> findAll = service.findAll();
		 return new ResponseEntity<ResponseCourse>(new ResponseCourse("OK","found", null, findAll),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/Delete/{id}")
	public void deleteCourse(@PathVariable("id") int id)
	{
		
		System.out.println("delete called");
		this.service.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseCourse> update(@PathVariable int id, @RequestBody Course course) {
		System.out.println("update controller called");
		Course cs=service.update(id);
		if (cs != null) {
			cs.setTitle(course.getTitle());
			cs.setDescription(course.getDescription());
			Course ncs=service.save(cs);
			return new ResponseEntity<ResponseCourse>( new ResponseCourse("ok","sucess",ncs,null), HttpStatus.OK);
		}
		return new ResponseEntity<ResponseCourse>( new ResponseCourse("Fail","fail",null,null), HttpStatus.NOT_FOUND);
	}
	
}
