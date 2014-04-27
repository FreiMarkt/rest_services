package it.unibz.inf.freimarkt.dao;

import it.unibz.inf.freimarkt.dao.dbController.DBConnectionPoolFactory;
import it.unibz.inf.freimarkt.dao.dbController.IDBConnectionPool;
import it.unibz.inf.freimarkt.entities.Member;

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

}
