package cst438hw2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import cst438hw2.domain.*;
import cst438hw2.service.CityService;
import cst438hw2.service.WeatherService;

@Controller
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/cities/{city}")
	public String getWeather(@PathVariable("city") String cityName, Model model) {
		CityInfo cityS = cityService.getCityInfo(cityName);
		model.addAttribute("city", cityS);
		return "index";
	}
	
}