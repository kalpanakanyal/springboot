package com.relevance.springbootstarter.course;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.relevance.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	//getting data as a parameter(pasing daqta to conroller)
	@RequestMapping(value = "")
	@ResponseBody
	public String practice(HttpServletRequest request) {

		String name = request.getParameter("name");
		if (name == null) {
			name = "world";
		}
		return "hello " + name;
	}
	
	//getting data through form(pasing daqta to conroller)
	@RequestMapping(value = "practice")
	@ResponseBody
	public String practiceForm() {

		String html = "<form method='post'>" + 
					  "<input type='text' name='name' />" +
				      "<input type='submit' value='greet me!' />" +
					  "</form>";
		return html;
	}
	@RequestMapping(value = "practice", method=RequestMethod.POST)
	@ResponseBody
	public String practicePost(HttpServletRequest request) {

		String name = request.getParameter("name");
		return "hello " + name;
	}
	
	
	//url segments(pasing data to conroller)
	@RequestMapping(value = "practice/{name}")
	@ResponseBody
	public String practiceUrlSegment(@PathVariable String name) {

		
		return "hello " + name;
	}
	
	
	
	
	//video course

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourse(@PathVariable String id) {
		return courseService.getAllCourse(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> get(@PathVariable String id) {
		return courseService.getCourse(id);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {

		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
