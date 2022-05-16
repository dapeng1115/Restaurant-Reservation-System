package com.demo.book.config;

import com.demo.book.kafkaService.KafkaService;
import com.demo.book.model.po.Book;
import com.demo.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

@Configuration      // 1.主要用于标记配置类
@EnableScheduling   // 2.开启定时任务
public class CronTask {

  private final Logger log = LoggerFactory.getLogger(CronTask.class);

  @Autowired
  private BookService bookService;
  @Autowired
  private KafkaService kafkaService;

  // execute in 23:59 0 59 23 * * *
  // https://tooltt.com/crontab/c/33.html
//  @Scheduled(cron = "*/5 * * * * *")
  @Scheduled(cron = "0 59 23 * * *")
  private void configureTasks() {
    log.info("execute cron task");
    List<Book> todayBooking = bookService.getTodayBooking(new Date());
    if (!todayBooking.isEmpty()) {
      todayBooking.forEach(each -> {
        log.info("add a book to kafka");
        kafkaService.fireBookCreatedEvent(each);
      });
    }

  }

}