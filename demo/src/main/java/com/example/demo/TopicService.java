package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic("1", "Java Spring Framework", "Springs Desc"),
        new Topic("2", "ReactJS", "ReactJS Framework"),
        new Topic("3", "JavaScript with ES6", "JavaScript ES6 Desc")
    ));
    
    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    //POST request method
    public void addTopic(Topic topic){
        topics.add(topic);
    }

    //PUT request method
    public void updateTopic(String id, Topic topic){
        for (int i=0; i < topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i,topic);
                return;
            }
        }
     }

     public void deleteTopic(String id){
        topics.removeIf(t->t.getId().equals(id));
    }

}