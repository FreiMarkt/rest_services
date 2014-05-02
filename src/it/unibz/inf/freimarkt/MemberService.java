package it.unibz.inf.freimarkt;

import it.unibz.inf.freimarkt.dao.DAOFactory;
import it.unibz.inf.freimarkt.dao.IDAO;
import it.unibz.inf.freimarkt.entities.Member;
import it.unibz.inf.freimarkt.entities.MemberColumns;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response smokeTest() {
		return Response.status(200).entity("Grumpy service").build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/save")
	public Response saveMember(Member m) {	
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		memberDAO.save(m);
		return Response.status(200).entity(m).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getByEmail")
	public Response getIdByEmail(Member input) {
		
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		List<Member> member = memberDAO.getAllByKey(input);
		
		return Response.status(200).entity(member).build();
	}
	
	/**
	 * This service updates email of the member.
	 * 
	 * Input should a JSON object that has two properties: email and id.
	 * 
	 * Return is the JSON object of the member
	 * 
	 * @param input
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateEmail")
	public Response updateEmail(JSONObject input) {
		String id = "";
		String email = "";
		try {
			id = input.getString(MemberColumns.ID.getColumnName());
			email = input.getString(MemberColumns.EMAIL.getColumnName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// prepare the object to send DAO update method
		Member tempMember = Member.getInstance();
		tempMember.setMemberID(id);
		tempMember.setEmail(email);
		
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		Boolean result = memberDAO.update(tempMember);
		
		return Response.status(200).entity(result).build();
	}
	/**
	 * This service updates MEMBER entry.
	 * JSON input can contain many fields that are going to be updated
	 * @param input
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateMember")
	public Response updateMember(JSONObject input) {
		List<MemberColumns> columnsToUpdate = new ArrayList<MemberColumns>();
		String id = "";
		String email = "";
		try {
			for (MemberColumns column : MemberColumns.values()) {
				if (input.has(column.getColumnName())) {
					columnsToUpdate.add(column);
				}
			}
			
			id = input.getString(MemberColumns.ID.getColumnName());
			email = input.getString(MemberColumns.EMAIL.getColumnName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// prepare the object to send DAO update method
		Member tempMember = Member.getInstance();
		tempMember.setMemberID(id);
		tempMember.setEmail(email);
		
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		Boolean result = memberDAO.update(tempMember);
		
		return Response.status(200).entity(result).build();
	}

}
