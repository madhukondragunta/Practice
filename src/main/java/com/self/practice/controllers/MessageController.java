package com.self.practice.controllers;

import com.self.practice.dto.MessageDto;
import com.self.practice.kafka.KafkaConsumerService;
import com.self.practice.kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private  KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @PostMapping("/api/messages")
    public String sendMessage(@RequestBody String content) {
        var message = new MessageDto(content);
        kafkaProducerService.send("TP.SPRING.TOPIC", message);
        return "Message sent with ID: " + message.id();
    }
    @GetMapping("/api/messages/consumed")
    public List<String> consumed() {
        return kafkaConsumerService.consumed();
    }
}
