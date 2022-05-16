package com.demo.location.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.location.model.po.Dish;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zrgj
 * @since 2022-05-10
 */
public interface IDishService extends IService<Dish> {

    List<Dish> getByLocationId(long id);
}
