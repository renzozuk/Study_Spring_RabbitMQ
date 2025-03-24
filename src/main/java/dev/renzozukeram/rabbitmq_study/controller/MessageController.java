package dev.renzozukeram.rabbitmq_study.controller;

import dev.renzozukeram.rabbitmq_study.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private RabbitMQProducer producer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ.");
    }
}
