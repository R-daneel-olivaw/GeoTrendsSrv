package aks.geo.trends.srv.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aks.geo.trends.srv.TrendingByCountry;
import aks.geo.trends.srv.spring.services.KeywordService;

@Controller
public class WelcomeController {

	@Autowired
	KeywordService keywordService;

	@RequestMapping(value = "/india", method = RequestMethod.GET)
	public String updateIndia(Model model) {

		TrendingByCountry trendsCountry = new TrendingByCountry();
		List<String> trendingIndia = trendsCountry.fetchTrendingForIndia();

		System.out.println("Trending for India : " + trendingIndia);

		keywordService.updateDatabase(trendingIndia, "IN");

		model.addAttribute("trending", trendingIndia);
		model.addAttribute("reg", "India");

		return "test";

	}

	@RequestMapping(value = "/us", method = RequestMethod.GET)
	public String updateUs(Model model) {

		TrendingByCountry trendsCountry = new TrendingByCountry();
		List<String> trendingIndia = trendsCountry.fetchTrendingForUS();

		System.out.println("Trending for US : " + trendingIndia);

		keywordService.updateDatabase(trendingIndia, "US");

		model.addAttribute("trending", trendingIndia);
		model.addAttribute("reg", "US");

		return "test";

	}

	@RequestMapping(value = "/query_count/{regionCode}/{keyword}", method = RequestMethod.GET)
	public String fetchQueryCount(@PathVariable String regionCode, @PathVariable String keyword) {
		
		Integer queryCount = keywordService.calculateQueryCount(regionCode, keyword);

		return "test_query_count";
	}
}
