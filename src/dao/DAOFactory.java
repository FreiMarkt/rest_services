package dao;

import items.PassiveMember;
import dao.dbController.DBConnectionPoolFactory;
import dao.dbController.IDBConnectionPool;

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
	public static IDAO<PassiveMember> createPassiveMemberDAO() {
		// there might be different implementations of DBConnectionPool but we need one now
		IDBConnectionPool dbConnectionPool = DBConnectionPoolFactory.create();
		
		// create instance of PassiveMemberDAO with a specified DBConnectionPool
		return PassiveMemberDAO.getInstance(dbConnectionPool);
	}

}
