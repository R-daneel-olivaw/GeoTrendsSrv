package aks.geo.trends.srv;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONObject;

import aks.geo.trends.srv.util.NetworkUtil;

public class TrendingByCountry {
	
	private JSONObject trending;

	public void fetch()
	{
		fetchTrending();
	}
	
	public List<String> fetchTrendingForIndia() {
		
		ensureData();
		
		List<String> trendingList = null;
		
		JSONArray jsonArray = (JSONArray) trending.get("3");

		trendingList = new ArrayList<>();
		for(int i=0;i<jsonArray.length();i++)
		{
			String item = jsonArray.get(i).toString();
			trendingList.add(item);
		}
		
		return trendingList;
	}

	public List<String> fetchTrendingForUS() {
		
		ensureData();
		
		List<String> trendingList = null;
		
		JSONArray jsonArray = (JSONArray) trending.get("1");

		trendingList = new ArrayList<>();
		for(int i=0;i<jsonArray.length();i++)
		{
			String item = jsonArray.get(i).toString();
			trendingList.add(item);
		}
		
		return trendingList;
	}

	private void fetchTrending() {
		
		JSONObject jsonObject = null;
		HttpGet httpGet = new HttpGet("http://hawttrends.appspot.com/api/terms/");
		
		NetworkUtil netUtil = new NetworkUtil();
		String stringContent = netUtil.handleGetRequest(httpGet);
		
		jsonObject = new JSONObject(stringContent);
		
		trending = jsonObject;
	}
	
	private void ensureData() {
		// TODO Auto-generated method stub
		
		if(trending==null)
		{
			fetchTrending();
		}
	}
}