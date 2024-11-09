package com.example.kafka.consumer.demo.consumer;

import com.example.kafka.consumer.demo.model.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

@KafkaListener(topics = "${message.topic.name}", groupId = "msgs", containerFactory = "kafkaListenerContainerFactory")
    public void listenWithHeaders(
            @Payload String message) {
        System.out.println(
                "Received Message: " + message);
    }

    @KafkaListener(
            topics = "${greeting.topic.name}",
            groupId = "greetings",
            containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(Greeting greeting) {
        // process greeting message
        System.out.println(
                "Received Message Greeting: " + greeting.toString());
    }
}
