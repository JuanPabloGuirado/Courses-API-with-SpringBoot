package io.juanpablo.springboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id){
		return courseRepository.findById(id).orElse(null); 	
	}
	
	//POST 
	public void addCourse(Course course) {
		courseRepository.save(course); 
	}
	
	//PUT
	public void updateCourse(Course course) {
		courseRepository.save(course);	
	}
	
	//DELETE
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
