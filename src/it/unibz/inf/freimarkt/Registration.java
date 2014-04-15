package it.unibz.inf.freimarkt;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class stands for REST service that takes in some parameters.
 * 
 * @author Dainius Jocas
 *
 */
@Path("/register")
public class Registration {
	
	@GET
	@Consumes("text/plain")
    @Produces({MediaType.TEXT_PLAIN})
	@Path("{userName}")
	public String echo(@PathParam("userName") String input) {
		String output = "moo: " + input;
		return output;
	}
	
	@GET
    @Produces({MediaType.TEXT_HTML})
	@Path("/moo")
	public String moo() {
		String output = "moo: ";
		return output;
	}
}
