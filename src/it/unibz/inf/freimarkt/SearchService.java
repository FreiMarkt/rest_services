package it.unibz.inf.freimarkt;

import it.unibz.inf.freimarkt.entities.SearchObject;
import it.unibz.inf.freimarkt.entities.SearchResults;

import java.util.ArrayList;
import java.util.List;

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
@Path("/search")
public class SearchService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response search(SearchObject searchObject) {
		List<SearchResults> searchResults = new ArrayList<SearchResults>();
		searchResults.add(SearchResults.newInstance());
		return Response.status(200).entity(searchResults).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEmptySearch")
	public Response getEmptySearchObject() {
		return Response.status(200).entity(SearchObject.newInstance()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showServices() {
		List<String> services = new ArrayList<String>();
		services.add("/search");
		return Response.status(200).entity(services).build();
	}
}
