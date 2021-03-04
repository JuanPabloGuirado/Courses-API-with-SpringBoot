package io.juanpablo.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	//We have to enclose the Arrays.asList as a parameter for a new ArrayList otherwise it will return
	//an immutable object which will throw an error 
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("java", "Java Core", "Basic Java Tools"),
			new Topic("javascript", "Basic JS", "Getting started with JS"),
			new Topic("sql", "DB SQL", "Getting started with databases")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	//POST 
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	//PUT
	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}	
	}
	
	//DELETE
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
