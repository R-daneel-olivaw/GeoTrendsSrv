package aks.geo.trends.srv.details;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import aks.geo.trends.srv.util.HtmlUtils;
import aks.geo.trends.srv.util.NetworkUtil;

public class TrendDetails {

	private String trend;
	private String regionCode;

	public TrendDetails(String trend, String regionCode) {
		this.trend = trend;
		this.regionCode = regionCode;
	}

	public void fetchRelated() {
		// http://www.google.com/trends/fetchComponent?hl=en-US&q=Mandana%20Karimi&geo=IN&cid=RISING_QUERIES_0_0

		URIBuilder builder;
		try {
			builder = new URIBuilder("http://www.google.com/trends/fetchComponent");

			List<NameValuePair> params = new ArrayList<>();

			params.add(new BasicNameValuePair("hl", "en-US"));
			params.add(new BasicNameValuePair("q", trend));
			params.add(new BasicNameValuePair("geo", regionCode));
			params.add(new BasicNameValuePair("cid", "RISING_QUERIES_0_0"));

			builder.addParameters(params);
			URI uri = builder.build();
			System.out.println(uri.toString());

			HttpGet relatedKeyWordsReq = new HttpGet(uri);
			NetworkUtil netUtils = new NetworkUtil();
			String response = netUtils.handleGetRequest(relatedKeyWordsReq);

			// System.out.println(response);

			HtmlUtils htmlParser = new HtmlUtils();
			List<String> related = htmlParser.parseRelated(response);
			
			System.out.println("Related : "+related);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
