package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TopicService {

	List<Topic> list=new ArrayList<>(Arrays.asList
			(new Topic("java","java framworks","java description"),
					new Topic("spring","spring framworks","spring description"),
					new Topic("javascript","javascript framworks","javascript description")
					));



	public List<Topic> getAllTopics() {
		return list;
	}
	public Topic getTopic(String id) {

		return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();

	}
	public void addTopic(Topic topic) {
		list.add(topic);

	}
	public void updateTopic(String id, Topic topic) {
	 for (int i = 0; i < list.size(); i++) {
		 Topic t=list.get(i);
		 if(t.getId().equals(id))
		 {
			 list.set(i, topic);
			 return ;
		 }
		 
		
	}
	}
	public void deleteTopic(String id) {
		list.removeIf(t -> t.getId().equals(id));
		
	}	
}
