package com.relevance.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepostiary extends CrudRepository<Course,String> {
   
	
	//custom methods , that doesn't require implementation because of the way we name it
	public List<Course> findByTopicId(String topicId);
	//public List<Course> findByName(String name);
	
	
	
}
