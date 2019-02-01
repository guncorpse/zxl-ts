package zxl.tools;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RequestUtils {
	
	public static String doGet(String url) throws Exception {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String result = "";
		try {
			httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
					.setConnectionRequestTimeout(35000)// 请求超时时间
					.setSocketTimeout(60000)// 数据读取超时时间
					.build();
			httpGet.setConfig(requestConfig);
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("发送GET请求错误：" + e.getMessage());
		} finally {
			try {
				if (null != response) {
					response.close();
				}
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (Exception e) {
				throw new Exception("资源释放错误：" + e.getMessage());
			}
		}
		return result;
	}

	public static String doPost(String url, String json) throws Exception {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String result = "";
		httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
				.setConnectionRequestTimeout(35000)// 设置连接请求超时时间
				.setSocketTimeout(60000)// 设置读取数据连接超时时间
				.build();
		httpPost.setConfig(requestConfig);
		// 设置请求头
		httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
		try {
			StringEntity se = new StringEntity(json, "utf-8");
			se.setContentEncoding("utf-8");
			se.setContentType("text/json");
			httpPost.setEntity(se);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != response) {
					response.close();
				}
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (Exception e) {
				throw new Exception("资源释放错误：" + e.getMessage());
			}
		}
		return result;
	}

}
