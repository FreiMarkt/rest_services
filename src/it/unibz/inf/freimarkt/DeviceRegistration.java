package it.unibz.inf.freimarkt;

import it.unibz.inf.freimarkt.dao.DAOFactory;
import it.unibz.inf.freimarkt.dao.IDAO;
import it.unibz.inf.freimarkt.entities.Device;
import it.unibz.inf.freimarkt.gcmConnector.GCMConnector;

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
@Path("/device")
public class DeviceRegistration {

	/**
	 * This service registers deviceID in the system.
	 * It expects a string which then can be translated in to a string. 
	 * @param deviceId
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/register")
	public Response saveMember(String deviceId) {
		System.out.println(deviceId);
		IDAO<Device> deviceDAO = DAOFactory.createDeviceDAO();
		
		Device device = Device.newInstance();
		device.setDeviceregistrationid(deviceId);
		
		boolean result = deviceDAO.save(device);
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAll() {
		IDAO<Device> deviceDAO = DAOFactory.createDeviceDAO();
		List<Device> devices = deviceDAO.loadAll();
		return Response.status(200).entity(devices).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sendMessage")
	public Response sendMessage() {
		GCMConnector conn = GCMConnector.newInstance();
		conn.method();
		return Response.status(200).entity("done").build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response smokeTest() {
		return Response.status(200)
				.entity("Antroid device registration service").build();
	}
}
