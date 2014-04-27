package it.unibz.inf.freimarkt.dao.dbController;

/**
 * Factory class for IDBConnectionPool implementations.
 * @author Dainius Jocas
 *
 */
public class DBConnectionPoolFactory {

	/**
	 * Returns default DBConnection pool implementation.
	 * TODO: clever implementation is needed. One day I'll make it.
	 * @return
	 */
	public static IDBConnectionPool create() {
		return DBConnectionPool.getInstance();
	}
	
}
