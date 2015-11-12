package aks.geo.trends.srv;

import org.apache.commons.lang.ArrayUtils;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import aks.geo.trends.srv.util.NetworkUtil;
import aks.geo.trends.srv.util.RegionsEnum;

public class QueryCountByRegion {

	public Float calculateCount(RegionsEnum region, String keyword) {

		System.out.println("Query : " + keyword);
		System.out.println("Region : " + region.getPrintName());

		JSONObject jsonObject = null;
		HttpGet httpGet = new HttpGet("http://www.google.com/trends/fetchComponent?hl=en-US&q=" + keyword
				+ "&cid=TIMESERIES_GRAPH_0&export=5&w=500&h=300&geo=" + region.getRegion() + "&date=today%207-d");

		NetworkUtil netUtil = new NetworkUtil();
		String stringContent = netUtil.handleGetRequest(httpGet);

		Document doc = Jsoup.parse(stringContent);
		Elements elems = doc.select("script[type]");

		String chartData = null;
		for (Element element : elems) {

			String content = element.html();

			if (content.indexOf("var chartData") != -1) {
				int start = content.indexOf("\"rows\":");
				int end = content.indexOf(",\"showHeadlines\"");
				chartData = content.substring(start, end);

				break;
			}
		}
		System.out.println(chartData);

		Float averagePopularity = processValues(chartData);
		System.out.println(keyword + " = " + averagePopularity);

		return averagePopularity;
	}

	private Float processValues(String chartData) {

		String[] dataElements = chartData.split(",\\[");

		Float average = new Float(0);
		int i = 0;
		StringBuilder countBank = new StringBuilder();

		for (String element : dataElements) {
			i++;

			String[] elementValues = element.split(",");
			ArrayUtils.reverse(elementValues);

			countBank.append(elementValues[3] + ",");
			System.out.println(elementValues[3]);
			if (!elementValues[3].equals("null")) {
				average += Integer.parseInt(elementValues[3]);
			}
		}

		System.out.println(countBank);

		average /= i;

		return average;
	}

}
