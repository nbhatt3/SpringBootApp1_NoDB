package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

@Autowired
private TopicService topicService;

//GET Request - all topics/all data
@RequestMapping("/topics")
    public List<Topic> getAllTopics( ) {
        return topicService.getAllTopics();

    }

//Get Request for a parameter sent via url - id
@RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

//POST request
@RequestMapping(method=RequestMethod.POST, value="/topics")
public void addTopic(@RequestBody Topic topic){
    topicService.addTopic(topic);
}

//PUT request
@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
    topicService.updateTopic(id, topic);
}

//DELETE request
@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
public void deleteTopic(@PathVariable String id){
    topicService.deleteTopic(id);
}

}