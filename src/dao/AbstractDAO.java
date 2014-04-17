package dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
		Boolean isSaved = executeSaveQuery(saveQuery);
		//return result status
		return isSaved;
	}
	
	/**
	 * @param saveQuery
	 * @return
	 */
	abstract Boolean executeSaveQuery(String saveQuery);

	/**
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
