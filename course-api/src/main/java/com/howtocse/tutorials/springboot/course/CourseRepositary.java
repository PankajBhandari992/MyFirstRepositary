package com.howtocse.tutorials.springboot.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface  CourseRepositary extends CrudRepository<Course,String> { 	 	

	public List<Course> findByTopicId(String topicId);
	
}
