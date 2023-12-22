package com.my.course.response;

import java.util.List;

import com.my.course.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCourse {
		
	private String msgString;
	private String statuString;
	private Course course;
	private List<Course> courses;
	
}
