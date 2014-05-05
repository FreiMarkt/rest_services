package it.unibz.inf.freimarkt;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This service is responsible to check if registration succeeded.
 * As of now it just checks if the code sent is equal to 12345
 * @author Dainius Jocas
 *
 */
@Path("/registration")
public class RegistrationConfirmationService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/checkCode")
	public Response saveMember(String code) {
		boolean isCodeOK = false;
		if ("1234".equalsIgnoreCase(code)) {
			isCodeOK = true;
		}
		return Response.status(200).entity(isCodeOK).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response smokeTest() {
		return Response.status(200).entity("Registration service").build();
	}
}
