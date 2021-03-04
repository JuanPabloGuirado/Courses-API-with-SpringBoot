package io.juanpablo.springboot.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		//The method findAll returns an iterable, then for each element we are 'adding' it to 'topics'
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
		return topicRepository.findById(id).orElse(null); 	
	}
	
	//POST 
	public void addTopic(Topic topic) {
		topicRepository.save(topic); 
	}
	
	//PUT
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);	
	}
	
	//DELETE
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
