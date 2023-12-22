package com.my.course.dao;

import org.springframework.data.repository.CrudRepository;

import com.my.course.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	Course findByTitle(String name);

}
