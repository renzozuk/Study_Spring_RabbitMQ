package dev.renzozukeram.rabbitmq_study.controller;

import dev.renzozukeram.rabbitmq_study.model.User;
import dev.renzozukeram.rabbitmq_study.publisher.RabbitMQJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageJsonController {

    @Autowired
    private RabbitMQJsonProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        producer.sendJsonMessage(user);
        return ResponseEntity.ok("JSON message sent to RabbitMQ.");
    }
}
