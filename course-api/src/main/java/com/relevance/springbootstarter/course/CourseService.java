package com.relevance.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepostiary courseRepositary;
	 
	 public List<Course> getAllCourse(String topicId){
		 List<Course> topics= new ArrayList<>();
		 
		 courseRepositary.findByTopicId(topicId).forEach(topics::add);
		 return topics;
	 }
	 public Optional<Course> getCourse(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		 
		 return courseRepositary.findById(id);
	 }
	public void addCourse(Course topic) {
		
		courseRepositary.save(topic);
	}
	public void updateCourse( Course course) {
		courseRepositary.save(course);
	}
	public void deleteCourse(String id) {
		courseRepositary.deleteById(id);
		
	}

}
