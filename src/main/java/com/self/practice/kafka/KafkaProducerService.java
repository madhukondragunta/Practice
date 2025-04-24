package com.self.practice.kafka;

import com.self.practice.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private  KafkaTemplate<String, MessageDto> kafkaTemplate;

    public void send(String topic, MessageDto message) {
        kafkaTemplate.send(topic,0, message.id(), message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.printf("""
                        Sent message:
                        Topic: %s
                        ID: %s
                        Content: %s
                        """, topic, message.id(), message.content());
                    } else {
                        System.err.println("Failed to send message: " + ex.getMessage());
                    }
                });
    }
}
