package com.my.course.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.course.dao.CourseRepository;
import com.my.course.entity.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository repo;
	
	public List<Course> findAll()
	{
		List<Course> lc= (List<Course>) repo.findAll();
		
		System.out.println("Service called");
		return lc;
	}
	
	
	public Course addCourse (Course ac)
	{
		Course result = repo.save(ac);
		System.out.println("saved");
		return result;
	}
	
	public void delete(int id)
	{
		System.out.println("delete called");
		 Course found = repo.findById(id).orElse(null);
		if (found!= null) {
			repo.deleteById(id);
		}else {
			
		
		}
	}


	public Course update(int id) {
//		System.out.println("update service called");
		  Course found = repo.findById(id).orElse(null);
		  return found;
	}


	public Course save(Course cs) {

		return repo.save(cs);
		
	}


	public Course findById(int id) {
		
		Course course=repo.findById(id).orElse(null);
		return course;
	}

}
