package com.demo.location.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.location.model.po.Location;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zrgj
 * @since 2022-05-10
 */
public interface ILocationService extends IService<Location> {

    Location saveLocation(Location location);

    List<Location> getAllLocations();
}
