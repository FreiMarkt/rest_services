package it.unibz.inf.freimarkt.gcmConnector;

import it.unibz.inf.freimarkt.dao.DAOFactory;
import it.unibz.inf.freimarkt.dao.IDAO;
import it.unibz.inf.freimarkt.entities.Device;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

/**
 * To send a message, the application server issues a 
 * - POST request to 
 * - https://android.googleapis.com/gcm/send.
 * - Authorization: key=YOUR_API_KEY
 * - Content-Type: application/json for JSON;
 * @author Dainius Jocas
 *
 */
public class GCMConnector {

	
	/*
	 * Static factory
	 */
	private GCMConnector() {}
	public static GCMConnector newInstance() {
		return new GCMConnector();
	}
	public void makeHTTPRequest() throws IOException {
		String url = "https://android.googleapis.com/gcm/send";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		//add request header
		con.setRequestProperty("Authorization", "AIzaSyDbPycn3WV-JHbWOhcIdPKQapl-ef5yxdc");
		con.setRequestProperty("Content-Type", "application/json");
		
		
		
	}
	
	public void method() {
		Sender sender = new Sender("AIzaSyDbPycn3WV-JHbWOhcIdPKQapl-ef5yxdc");
		Message message = new Message.Builder().delayWhileIdle(true)
				.addData("message", "timebank")
				.addData("phoneNumber", "+37068600597")
				.addData("securityCode", "1234")
				.build();
		String registrationId = getRegistrationID();
		try {
			Result result = sender.send(message, registrationId, 5);
			System.out.println("notification has been sent");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void method(String phoneNumber, String securityCode) {
		Sender sender = new Sender("AIzaSyDbPycn3WV-JHbWOhcIdPKQapl-ef5yxdc");
		Message message = new Message.Builder()
				.delayWhileIdle(false)
				.addData("message", "timebank")
				.addData("phoneNumber", phoneNumber)
				.addData("securityCode", securityCode)
				.build();
		String registrationId = getRegistrationID();
		try {
			Result result = sender.send(message, registrationId, 5);
			System.out.println("parameterized notification has been sent");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	private String getRegistrationID() {
		IDAO<Device> deviceDAO = DAOFactory.createDeviceDAO();
		List<Device> devices = deviceDAO.loadAll();
		return devices.get(0).getDeviceregistrationid();
	}
}
