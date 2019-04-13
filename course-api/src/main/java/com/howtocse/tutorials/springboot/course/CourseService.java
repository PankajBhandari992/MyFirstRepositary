package com.howtocse.tutorials.springboot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepositary courseRepositary;
		
	public List<Course> getAllCourses(String topicId){
		List<Course> course= new ArrayList<Course>();
		courseRepositary.findByTopicId(topicId).forEach(course::add);
		return course;
	}

	public Optional<Course> getCourse(String courseId) {
		return courseRepositary.findById(courseId);
	}

	public void addCourse(Course course) {
		courseRepositary.save(course);
	}

	public void updateCourse(Course course) {
		courseRepositary.save(course);
	}

	public void deleteCourse(String courseId) {
		courseRepositary.deleteById(courseId);
	}

}
