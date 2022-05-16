package com.demo.location.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("book")
public interface BookFeignService {

    @DeleteMapping("/delete-by-location-id/{id}")
    @ResponseBody
    void deleteBookByLocationId(@PathVariable("id") Long id);
}
