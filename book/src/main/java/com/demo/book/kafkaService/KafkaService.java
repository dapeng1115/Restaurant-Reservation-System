package com.demo.book.kafkaService;

import com.demo.book.model.po.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;

    public void fireBookCreatedEvent(Book book) {
        kafkaTemplate.send("writer", book);
    }
}
