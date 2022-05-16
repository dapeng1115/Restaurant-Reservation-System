package com.demo.location.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.location.model.po.Location;
import com.demo.location.mapper.LocationMapper;
import com.demo.location.service.ILocationService;
import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zrgj
 * @since 2022-05-10
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements ILocationService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public Location saveLocation(Location location) {
        Integer result = baseMapper.insert(location);
        try {
            fireLocationCreatedEvent(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

  @Override
  public List<Location> getAllLocations() {
    return this.baseMapper.selectList(new LambdaQueryWrapper<>());
  }

  private void fireLocationCreatedEvent(Location location) {
//        kafkaTemplate.send("location", location.getId() + "created", location);
    }

}
