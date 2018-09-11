package com.relevance.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepostiary topicRepositary;
	 
	 public List<Topic> getAllTopics(){
		 List<Topic> topics= new ArrayList<>();
		 
		 topicRepositary.findAll().forEach(topics::add);
		 return topics;
	 }
	 public Optional<Topic> getTopic(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		 
		 return topicRepositary.findById(id);
	 }
	public void addTopic(Topic topic) {
		
		topicRepositary.save(topic);
	}
	public void updateTopic(String id, Topic topic) {
		topicRepositary.save(topic);
	}
	public void deleteTopic(String id) {
		topicRepositary.deleteById(id);
		
	}

}
