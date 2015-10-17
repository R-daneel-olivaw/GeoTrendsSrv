package aks.geo.trends.srv.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import aks.geo.trends.srv.TrendingByCountry;
import aks.geo.trends.srv.spring.services.KeywordService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Tasks {
	
	private final Logger logger = LoggerFactory.getLogger(Tasks.class);
	
	@Autowired
	KeywordService keywordService;
	
	@Scheduled(fixedDelay=60000)
	public void updateTrendingKeywordsIndia()
	{
		logger.info("Requesting keywords for India");
		
		TrendingByCountry trendsCountry = new TrendingByCountry();
		List<String> trendingIndia = trendsCountry.fetchTrendingForIndia();
		
		logger.debug("Trending for India : "+trendingIndia);
		
		logger.trace("Updating DB for keywords from India");
		keywordService.updateDatabase(trendingIndia, "IN");
		logger.trace("completed update of DB for keywords from India");
		
		logger.info("Completed requesting keywords for India");
	}
	
	@Scheduled(initialDelay=10000, fixedDelay=60000)
	public void updateTrendingKeywordsUS()
	{
		logger.info("Requesting keywords for US");
		
		TrendingByCountry trendsCountry = new TrendingByCountry();
		List<String> trendingUS = trendsCountry.fetchTrendingForUS();
		
		logger.debug("Trending for US : "+trendingUS);
		
		logger.trace("Updating DB for keywords from US");
		keywordService.updateDatabase(trendingUS, "US");
		logger.trace("completed update of DB for keywords from US");
		
		logger.info("Completed requesting keywords for US");
	}

}
