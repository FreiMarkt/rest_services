package it.unibz.inf.freimarkt;

import it.unibz.inf.freimarkt.dao.DAOFactory;
import it.unibz.inf.freimarkt.dao.IDAO;
import it.unibz.inf.freimarkt.entities.OfferObject;

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
 * Service that helps to get offers.
 * @author Dainius Jocas
 *
 */
@Path("/offer")
public class OfferService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/makeOffer")
	public Response makeOffer(OfferObject offerObject) {
		IDAO<OfferObject> offerDAO = DAOFactory.createOfferDAO();
		boolean isSaved = offerDAO.save(offerObject);
		return Response.status(200).entity("true").build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEmptyOffer")
	public Response getEmpty() {
		return Response.status(200).entity(OfferObject.newInstance()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listServices() {
		List<String> services = new ArrayList<String>();
		services.add("/makeOffer");
		services.add("/getEmptyOffer");
		return Response.status(200).entity(services).build();
	}
}
