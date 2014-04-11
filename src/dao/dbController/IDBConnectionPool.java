package dao.dbController;

import java.sql.Connection;

/**
 * Implementation must know only how to provide a valid DB connection object.
 * Implementation should take care of all the checks on the connection.s
 * 
 * @author Dainius Jocas
 *
 */
public interface IDBConnectionPool {

	/**
	 * Method that returns an open DB connection.
	 * @return
	 */
	Connection getConnection();
}
