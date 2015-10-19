package aks.geo.trends.srv.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworkUtil {

	private final Logger logger = LoggerFactory.getLogger(NetworkUtil.class);

	public String handleGetRequest(HttpGet gReq) {
		String stringContent = null;
		
		logger.trace("Before sending request "+gReq.toString());
		
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

			try (CloseableHttpResponse response1 = httpclient.execute(gReq)) {

				stringContent = EntityUtils.toString(response1.getEntity());

			} catch (ClientProtocolException e) {
				logger.error(e.getMessage(), e);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		logger.trace("After sending request "+gReq.toString());
		
		return stringContent;
	}

}
