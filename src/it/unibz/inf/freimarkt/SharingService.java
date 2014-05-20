package it.unibz.inf.freimarkt;

import java.util.ArrayList;
import java.util.List;

import it.unibz.inf.freimarkt.entities.ShareObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Dainius Jocas
 *
 */
@Path("/share")
public class SharingService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/shareHours")
	public Response shareHours(ShareObject sharedHours) {
		return Response.status(200).entity("true").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEmptyShareObject")
	public Response shareHours() {
		return Response.status(200).entity(ShareObject.newInstance()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listServices() {
		List<String> services = new ArrayList<String>();
		services.add("/shareHours");
		services.add("/getEmptyShareObject");
		return Response.status(200).entity(ShareObject.newInstance()).build();
	}
}
