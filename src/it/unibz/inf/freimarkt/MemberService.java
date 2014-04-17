package it.unibz.inf.freimarkt;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.DAOFactory;
import dao.IDAO;
import entities.Member;
/**
 * This service helps dealing with member of the timebank.
 * @author Dainius Jocas
 *
 */
@Path("/member")
public class MemberService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAll() {
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		List<Member> members = memberDAO.loadAll();
		return Response.status(200).entity(members).build();
	}
	

}
