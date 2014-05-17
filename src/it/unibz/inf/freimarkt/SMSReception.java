package it.unibz.inf.freimarkt;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Dainius Jocas
 *
 */
@Path("/sms")
public class SMSReception {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/receive")
	public Response saveMember(String message) {
		System.out.println("SMSReception" + message	);
		return Response.status(200).entity(message).build();
	}
}
