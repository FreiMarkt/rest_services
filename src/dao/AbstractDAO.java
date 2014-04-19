package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.dbController.IDBConnectionPool;

/**
 * This abstract class implements common functionality for the IDAO 
 * implementation classes.
 * @author Dainius Jocas
 * @param <T>
 *
 */
abstract class AbstractDAO<T> implements IDAO<T> {
	
	/*
	 * DAO should be able to use a connection.
	 */
	private IDBConnectionPool mDBConnectionPool;
	
	AbstractDAO(IDBConnectionPool dbConnectionPool) {
		this.mDBConnectionPool = dbConnectionPool;
	}
	
	Connection getDBConnection(){
		return this.mDBConnectionPool.getConnection();
	}
	
	/* (non-Javadoc)
	 * @see dao.IDAO#save(java.lang.Object)
	 */
	@Override
	public boolean save(T object) {
		// prepare save query string
		String saveQuery = prepareSaveQuery(object);
		// execute query
		Boolean isSaved = executeSaveQuery(saveQuery, object);
		//return result status
		return isSaved;
	}
	
	/**
	 * @param saveQuery
	 * @param object
	 * @return
	 */
	Boolean executeSaveQuery(String saveQuery, T object){
		try {
			Connection connection = getDBConnection();
			PreparedStatement statement = 
					connection.prepareStatement(saveQuery);
			setValues(connection, statement, object);
			statement.executeUpdate();
			
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.TRUE;
	}

	/**
	 * @param statement
	 * @param object
	 * @throws SQLException 
	 */
	abstract void setValues(Connection connection, 
			PreparedStatement statement, T object) throws SQLException;

	/**
	 * Gets a return SQL statement which for every entity is different,
	 * @param object
	 * @return
	 */
	abstract String prepareSaveQuery(T object);

	/**
	 * Executes actual query.
	 * No null can be returned by this method.
	 * @param statement
	 * @return
	 */
	List<T> executeLoadAll(String query) {
		List<T> resultList = null;
		try {
			// prepare statement object
			Statement stmt = getDBConnection().createStatement();
			// execute query
			ResultSet results = stmt.executeQuery(query);
			// build list of objects
			resultList = createResultList(results);
			// close result set
			results.close();
			// close statement object
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// check for null
		if (null == resultList) {
			resultList = new ArrayList<T>();
		}
		
		// return result list
		return resultList;
	}

	/**
	 * @param results
	 * @return
	 */
	abstract List<T> createResultList(ResultSet results);

}
