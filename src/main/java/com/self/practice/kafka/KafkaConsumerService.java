package com.self.practice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import com.self.practice.dto.MessageDto;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    List<String> mstList = new ArrayList<>();
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload MessageDto message) {
        System.out.printf("""
            Received message:
            ID: %s
            Content: %s
            Timestamp: %s
            """, message.id(), message.content(), message.timestamp());
        mstList.add(message.content());
    }

    public List<String> consumed(){
        return mstList;
    }

}