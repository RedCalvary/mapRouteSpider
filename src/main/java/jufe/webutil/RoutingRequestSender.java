package jufe.webutil;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RoutingRequestSender {
	private static String drivingUrl = "http://restapi.amap.com/v3/direction/driving";
	private static String doGet(String url, Map<String, String> param) {//using get method to send request to target server

        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {//built target URL
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;//return the respond
    }
	public String sendRoutingRequest(String origin, String destination)//in put the coordinate of outset and destination
	{
		
		//pattern: Longitude, latitude, both less than 6 digital number
		Map<String, String> param = new HashMap<String, String>();//built a complete URL with right parameters
		//key(used to call the API service), origin, destination, output(set to use XML)
		DeveloperKeyPool keys = new DeveloperKeyPool();
		param.put("key", keys.getKey());
		param.put("origin", origin);
		param.put("destination", destination);
		param.put("output", "XML");
		return doGet(this.drivingUrl, param);
	}
}
