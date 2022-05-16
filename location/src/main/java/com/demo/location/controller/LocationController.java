package com.demo.location.controller;

import com.demo.location.feignService.BookFeignService;
import com.demo.location.model.po.Dish;
import com.demo.location.model.po.Location;
import com.demo.location.service.IDishService;
import com.demo.location.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
class LocationController {

	@Autowired
	private ILocationService locationService;

	@Autowired
	private BookFeignService bookFeignService;

	@Autowired
    private IDishService dishRepository;

	@GetMapping("/location-by-id")
	@ResponseBody
	public Location getLocationById(Long id) {
		return locationService.getById(id);
	}

	@GetMapping("/all-locations")
	@ResponseBody
	public List<Location> getAllLocations() {
		return locationService.getAllLocations();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView locationList() {
		return new ModelAndView("locationList", "locations", locationService.list());
	}

	@RequestMapping(value = "/form.html", method = RequestMethod.GET)
	public ModelAndView form() {
		return new ModelAndView("locationForm", "location", new Location());
	}



	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") long id, Model model) {
		Location location = locationService.getById(id);
		List<Dish> dishes = dishRepository.getByLocationId(id);
		location.setDish(dishes);
		model.addAttribute("location", location);
		return "locationPreview";
	}

	@PostMapping("/create")
	public ModelAndView post(Location location, Model model) {
		locationService.saveLocation(location);
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("id") long id) {
		bookFeignService.deleteBookByLocationId(id);
		locationService.removeById(id);
		return new ModelAndView("success");
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") String id, Model model) {
		Location data = locationService.getById(id);
		model.addAttribute("location", data);
		return "locationEdit";
	}

	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, Location location) {
		locationService.updateById(location);
		return "success";
	}



}
