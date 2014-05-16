package it.unibz.inf.freimarkt;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Recovery services for the timebank.
 * @author Dainius Jocas
 *
 */
@Path("/recovery")
public class RecoveryService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recoverPassword")
	public Response recoverPassword(JSONObject object) {
		try {
			System.out.println(object.getString("email"));
			System.out.println(object.getString("phoneNumber"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(true).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServices() {
		List<String> services = new ArrayList<String>();
		services.add("/recoverPassword");
		return Response.status(200).entity(services).build();
	}
}
