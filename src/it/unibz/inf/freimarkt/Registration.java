package it.unibz.inf.freimarkt;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class stands for REST service that takes in some parameters.
 * GOOGLE: AIzaSyDbPycn3WV-JHbWOhcIdPKQapl-ef5yxdc
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
	@Path("/query")
	public Response getUsers(
		@QueryParam("from") int from,
		@QueryParam("to") int to,
		@QueryParam("orderBy") List<String> orderBy) {
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
	
	@GET
    @Produces({MediaType.TEXT_HTML})
	@Path("/moo")
	public String moo() {
		String output = "moo: ";
		return output;
	}
}
