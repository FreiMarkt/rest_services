package it.unibz.inf.freimarkt.dao.dbController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class acts as a DB connection pool.
 * Connection pool is preferred solution to creating connection on demand
 * because it makes the work with connections faster, e.g. little to no 
 * overhead getting new DB connection.
 * 
 * This is a very dummy implementation, more refined solutions is needed.
 * 
 * Singleton class.
 * 
 * @author Dainius Jocas
 *
 */
public class DBConnectionPool implements IDBConnectionPool{

	/**
	 * Private constructor
	 */
	private DBConnectionPool() {}
	
	/**
	 * Private holder class.
	 * @author Dainius Jocas
	 *
	 */
	private static class DBConnectionPoolHolder {
		static final DBConnectionPool instance = new DBConnectionPool();
	}
	
	/**
	 * Factory method
	 * @return
	 */
	public static DBConnectionPool getInstance() {
		return DBConnectionPoolHolder.instance;
	}

	/* (non-Javadoc)
	 * @see dao.dbController.IDBConnectionPool#getConnection()
	 */
	public Connection getConnection() {
		// create new connection
		Connection newConnection = createConnection();
		
		return newConnection;
	}

	/**
	 * Just a method to establish a connection.
	 * @return newly create DB connection
	 */
	private Connection createConnection() {
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			// get connection to the database
			// parent class knows how to do it
			connection = DriverManager.getConnection(
							// this should be somehow parameterized
							"jdbc:postgresql://192.168.1.66:5432/timebankdb", 
							"postgres", // username
							"postgres"); // password
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
