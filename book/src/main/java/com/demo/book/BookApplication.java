package com.demo.book;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableSwagger2Doc // 开启Swagger2
@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*", "com.demo.book.mapper"})  //
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*",
    "com.demo.book"})
// 开启服务发现
@EnableFeignClients(basePackages= "com.demo.book.feignService")
@EnableDiscoveryClient
public class BookApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext run = SpringApplication.run(BookApplication.class, args);
  }

}
