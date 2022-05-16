package com.demo.consumer.config;

import com.demo.consumer.entity.Book;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class ConsumerDeserializer extends JsonDeserializer<Book> {

    public ConsumerDeserializer() {
        super(Book.class);
    }
}
