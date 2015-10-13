package aks.geo.trends.srv.spring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aks.geo.trends.srv.TrendingByCountry;

@Controller
@RequestMapping("/test")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String welcomeScreen(Model model) {

		TrendingByCountry trendsCountry = new TrendingByCountry();
		List<String> trendingIndia = trendsCountry.fetchTrendingForIndia();
		
		System.out.println("Trending for India : "+trendingIndia);
		
		model.addAttribute("trending_india", trendingIndia);

		return "test";

	}

}
