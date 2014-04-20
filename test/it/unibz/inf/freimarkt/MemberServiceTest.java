package it.unibz.inf.freimarkt;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @author Dainius Jocas
 *
 */
public class MemberServiceTest {
	
	@Test
	public void testSave001() throws JSONException, ClientProtocolException, IOException {
		String url = "http://localhost:8080/howaboutno/moo/member/save";
		String json = 
				"{\"firstname\":\"Dainius\",\"lastname\":\"Jocas\",\"username\":\"dainiusjocas\",\"ppassword\":\"password\",\"age\":25,\"gender\":true,\"address\":\"vilnius, lietuva\",\"city\":\"Vilnius\",\"country\":\"Lithuania\",\"email\":\"dainius.jocas@gmail.com\",\"phonenumber\":\"+37068600597\",\"paymentStatus\":true,\"fiftyfivemember\":true,\"postalcode\":\"86430\",\"birthday\":\"3889-05-11\",\"roleId\":3,\"memberID\":\"blablabla\"}";
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(
		        JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client
		        .resource(url);
		ClientResponse response = webResource.accept("application/json")
		        .type("application/json").post(ClientResponse.class, json);
		if (response.getStatus() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + response.getStatus());
		}

	}
	
	@Test
	public void testSelectByEmail001() throws JSONException, ClientProtocolException, IOException {
		String url = "http://localhost:8080/howaboutno/moo/member/getByEmail";
		
		ClientConfig clientConfig = new DefaultClientConfig();
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client
		        .resource(url);
		
		JSONObject inputJsonObj = new JSONObject();
		inputJsonObj.put("email", "me@company.com");
		
		ClientResponse response = 
				webResource
				.accept("application/json")
		        .type("application/json")
		        .post(ClientResponse.class, inputJsonObj);
		
		if (response.getStatus() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : "
		            + response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println(output);

	}
	
	
	

}
