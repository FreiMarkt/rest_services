package howaboutno;

import items.PassiveMember;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import dao.IDAO;
import dao.DAOFactory;


/**
 * This class serves as a prototype.
 * @author Dainius Jocas
 *
 */
//Sets the path to base URL + /hello
@Path("/no")
public class No {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {

		return "How about no plain text?";
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> How about no xml?" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		StringBuilder body = new StringBuilder();
		body.append("<h1>List of passive members:</h1></br>");
		
		// get DAO that is needed that implements IDAO interface
		IDAO<PassiveMember> passiveMemberDAO = DAOFactory.createPassiveMemberDAO();
		
		List<PassiveMember> passiveMembers = passiveMemberDAO.loadAll();
		
		for (PassiveMember passiveMember : passiveMembers) {
			body.append("<p>")
			.append(passiveMember.toString())
			.append("</p><br>");
		}
		
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + body + "</body></h1>" + "</html> ";
	}

}
