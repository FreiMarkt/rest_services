package it.unibz.inf.freimarkt;

import it.unibz.inf.freimarkt.dao.DAOFactory;
import it.unibz.inf.freimarkt.dao.IDAO;
import it.unibz.inf.freimarkt.entities.Member;
import it.unibz.inf.freimarkt.entities.MemberColumns;
import it.unibz.inf.freimarkt.utilities.SecurityCodeGenerator;

import java.util.List;
import java.util.UUID;

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
		
		SecurityCodeGenerator securityCodeGenerator = 
				SecurityCodeGenerator.newInstance();
		String securityCode = securityCodeGenerator.generateSecurityCode();
	
		// unfortunately this code can work only in the server that has an outgoing connection enabled
//		// send SMS confirmation code
//		GCMConnector conn = GCMConnector.newInstance();
//		conn.method(m.getPhonenumber(), securityCode);
		
		return Response.status(200).entity(m).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteMember(Member m) {	
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		memberDAO.delete(m);
		return Response.status(200).entity(m).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response loginMember(Member m) {	
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		List<Member> members = memberDAO.getAllByKey(m);
		boolean isLoggedIn;
		if (1 == members.size()) {
			isLoggedIn = true;
		} else {
			isLoggedIn = false;
		}
		return Response.status(200).entity(isLoggedIn).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getByKey")
	public Response getMemberByKey(Member m) {	
		if (null != m.getEmail()) {
			String tempEmail = m.getEmail();
			tempEmail =  tempEmail.replace("%40", "@");
			m.setEmail(tempEmail);
		}
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		List<Member> members = memberDAO.getAllByKey(m);
		
		return Response.status(200).entity(members.get(0)).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getById")
	public Response getMemberById(Member m) {	
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		Member member = memberDAO.getById(UUID.fromString(m.getMemberid()));
		return Response.status(200).entity(member).build();
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
		tempMember.setMemberid(id);
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
	public Response updateMember(Member input) {
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		Member tempMember = 
				memberDAO.getById(UUID.fromString(input.getMemberid()));
		// TODO refresh field values.
		memberDAO.delete(tempMember);
		memberDAO.save(input);
		return Response.status(200).entity(input).build();
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
	@Path("/realUpdate")
	public Response realUpdate(Member input) {
		IDAO<Member> memberDAO = DAOFactory.createMemberDAO();
		boolean isUpdated = memberDAO.update(input);
		return Response.status(200).entity(isUpdated).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEmptyMember")
	public Response getEmptyMember() {
		return Response.status(200).entity(Member.getInstance()).build();
	}

}
