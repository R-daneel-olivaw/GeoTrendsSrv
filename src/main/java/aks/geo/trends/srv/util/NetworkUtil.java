package aks.geo.trends.srv.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class NetworkUtil {
	
	public String handleGetRequest(HttpGet gReq)
	{
		String stringContent = null;
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

			try (CloseableHttpResponse response1 = httpclient.execute(gReq)) {

				stringContent = EntityUtils.toString(response1.getEntity());

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return stringContent;
	}

}
