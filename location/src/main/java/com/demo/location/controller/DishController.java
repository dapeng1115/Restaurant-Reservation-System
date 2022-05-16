package com.demo.location.controller;


import com.demo.location.model.po.Dish;
import com.demo.location.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zrgj
 * @since 2022-05-10
 */
@Controller
@RequestMapping("/dish")
public class DishController {

  @Autowired
  private IDishService dishService;

  @GetMapping("/add/{locationId}")
  public String toCreate(@PathVariable("locationId") Long locationId, Model model) {
    Dish dish = new Dish();
    dish.setLocationId(locationId);
    model.addAttribute("dish", dish);
    return "dishAdd";
  }

  @PostMapping
  public String create(Dish dish) {
    dishService.save(dish);
    return "success";
  }

  @PostMapping("/delete/{id}")
  public String delete(@PathVariable("id") Long id) {
    dishService.removeById(id);
    return "success";
  }

}
