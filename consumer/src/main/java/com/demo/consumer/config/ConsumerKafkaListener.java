package com.demo.consumer.config;

import com.demo.consumer.entity.Book;
import com.demo.consumer.mapper.ConsumerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;


@Component
public class ConsumerKafkaListener {

    private final Logger log = LoggerFactory.getLogger(ConsumerKafkaListener.class);

    @Autowired(required = false)
    private ConsumerMapper consumerMapper;

    @KafkaListener(topics = "writer")
    public void order(Book book, Acknowledgment acknowledgment) {
        log.info("Received reservation");
        consumerMapper.insert(book);
        acknowledgment.acknowledge();
    }

}