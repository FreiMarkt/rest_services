package it.unibz.inf.freimarkt.dao;

import it.unibz.inf.freimarkt.dao.dbController.DBConnectionPoolFactory;
import it.unibz.inf.freimarkt.dao.dbController.IDBConnectionPool;
import it.unibz.inf.freimarkt.entities.Device;
import it.unibz.inf.freimarkt.entities.Member;
import it.unibz.inf.freimarkt.entities.OfferObject;

/**
 * Factory class that knows how to create IDAO implementation objects.
 * @author Dainius Jocas
 *
 */
public class DAOFactory {
	
	/**
	 * Static factory method that creates PassiveMemberDAO object.
	 * @return
	 */
	public static IDAO<Member> createMemberDAO() {
		// there might be different implementations of DBConnectionPool but we need one now
		IDBConnectionPool dbConnectionPool = DBConnectionPoolFactory.create();
		
		// create instance of PassiveMemberDAO with a specified DBConnectionPool
		return MemberDAO.getInstance(dbConnectionPool);
	}

	/**
	 * @return
	 */
	public static IDAO<Device> createDeviceDAO() {
		// there might be different implementations of DBConnectionPool but we need one now
		IDBConnectionPool dbConnectionPool = DBConnectionPoolFactory.create();
		return DevicesDAO.getInstance(dbConnectionPool);
	}

	/**
	 * @return
	 */
	public static IDAO<OfferObject> createOfferDAO() {
		IDBConnectionPool dbConnectionPool = DBConnectionPoolFactory.create();
		return OfferDAO.newInstance(dbConnectionPool);
	}

}
