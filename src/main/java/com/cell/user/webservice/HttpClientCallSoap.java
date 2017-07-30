package com.cell.user.webservice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientCallSoap {

	private static String postUrl = "http://0.0.0.0:8050/ServiceApi.asmx?wsdl";

	private static String method = "http://www.uradiosys.com/HostAddOrUpdateByOtherSys";

	private boolean callWebService() {
		String request = buildRequest();
		String response = doPostSoapRequest(request);
		String status = getStatus(response);
		return false;
	}

	private String buildRequest() {
		StringBuilder result = new StringBuilder();
		result.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		result.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n");

		result.append(" <soap:Body>\n");
		result.append("</soap:Envelope>");
		return result.toString();
	}

	private String doPostSoapRequest(String requestData) {
		// HttpClientBuilder & HttpClient
		CloseableHttpClient httpClient = null;
		String result = "";
		try {
			httpClient = HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost(postUrl);
			// socketTimeout & connectTimeout
			RequestConfig requestCfg = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
			// set request data
			StringEntity data = new StringEntity(requestData, Charset.forName("UTF-8"));
			httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
			httpPost.setConfig(requestCfg);
			httpPost.setHeader("SOAPAction", method);
			httpPost.setEntity(data);
			// execute post
			CloseableHttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				// sueccess & get response content
				HttpEntity httpEntity = response.getEntity();
				result = (httpEntity != null ? EntityUtils.toString(httpEntity, "UTF-8") : null);
			}
		} catch (Exception e) {

		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
			}
		}
		return result;
	}

	private String getStatus(String response) {
		Matcher m = Pattern.compile("<status>*>(.*?)</status>").matcher(response);
		return m.find() ? m.group(1) : null;
	}
}
