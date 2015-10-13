package aks.geo.trends.srv;

import java.util.List;

import aks.geo.trends.srv.details.TrendDetails;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		TrendingByCountry trendsCountry  = new TrendingByCountry();
		
		
		List<String> trendingIndia = trendsCountry.fetchTrendingForIndia();		
		System.out.println("Trending for India : "+trendingIndia);
//		fetchDetails(trendingIndia,"IN");
		
		List<String> trendingUS = trendsCountry.fetchTrendingForUS();		
		System.out.println("Trending for US : "+trendingUS);
		
	}

	private static void fetchDetails(List<String> trendingIndia, String string) {
		System.out.println("Region : "+string);
		
		for (String trendingKeyword : trendingIndia) {
			
			TrendDetails trendDetails = new TrendDetails(trendingKeyword, "IN");
			System.out.println("Keyword : "+trendingKeyword);
			trendDetails.fetchRelated();
			
			break;
		}
	}
}
