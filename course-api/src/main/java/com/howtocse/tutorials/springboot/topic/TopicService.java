package com.howtocse.tutorials.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepositary topicRepositary;
	
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Java Script", "Java Script Description")));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics= new ArrayList<Topic>();
		topicRepositary.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopic(String topicId) {
		//return topics.stream().filter(t -> t.getId().equalsIgnoreCase(topicId)).findFirst().get();
		return topicRepositary.findById(topicId);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepositary.save(topic);
	}

	public void updateTopic(Topic topic, String topicId) {
		/*
		 * for(int i=0; i<topics.size();i++){
		 * if(topics.get(i).getId().equalsIgnoreCase(topicId)){ topics.set(i, topic); }
		 * }
		 */
		topicRepositary.save(topic);
	}

	public void deleteTopic(String topicId) {
		//topics.removeIf(t->t.getId().equalsIgnoreCase(topicId));
		topicRepositary.deleteById(topicId);
	}

}
