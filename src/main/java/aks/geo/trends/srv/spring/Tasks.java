package aks.geo.trends.srv.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import aks.geo.trends.srv.TrendingByCountry;
import aks.geo.trends.srv.spring.services.KeywordService;

@Component
public class Tasks {
	
	@Autowired
	KeywordService keywordService;
	
	@Scheduled(fixedDelay=60000)
	public void updateTrendingKeywordsIndia()
	{
		TrendingByCountry trendsCountry = new TrendingByCountry();
		List<String> trendingIndia = trendsCountry.fetchTrendingForIndia();
		
		System.out.println("Trending for India : "+trendingIndia);
		
		keywordService.updateDatabase(trendingIndia, "IN");
	}
	
	@Scheduled(fixedDelay=60000)
	public void updateTrendingKeywordsUS()
	{
		TrendingByCountry trendsCountry = new TrendingByCountry();
		List<String> trendingIndia = trendsCountry.fetchTrendingForUS();
		
		System.out.println("Trending for US : "+trendingIndia);
		
		keywordService.updateDatabase(trendingIndia, "US");
	}

}
