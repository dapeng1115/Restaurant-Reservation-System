package com.demo.book.feignService;

import com.demo.book.model.dto.LocationDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("location")
public interface LocationFeignService {

  @GetMapping("/location-by-id")
  @ResponseBody
  LocationDto getLocationById(Long id);

  @GetMapping("/all-locations")
  @ResponseBody
  List<LocationDto> getAllLocations();

}
