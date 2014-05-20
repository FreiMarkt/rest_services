package it.unibz.inf.freimarkt.dao;

import it.unibz.inf.freimarkt.dao.dbController.IDBConnectionPool;
import it.unibz.inf.freimarkt.entities.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	

	@Override
	public boolean update(T object) {
		String updateSQL = getUpdateSQL();
		boolean isUpdated = executeUpdate(updateSQL, object);
		return isUpdated;
	}
	
	/**
	 * @param updateQuery
	 * @param object
	 * @return
	 */
	private boolean executeUpdate(String updateQuery, T object) {
		Boolean isUpdated = Boolean.FALSE;
		PreparedStatement updateSQL = null;
		try {
			Connection connection = this.getDBConnection();
			updateSQL = connection.prepareStatement(updateQuery);
			
			setUpdateValues(updateSQL, object);
			updateSQL.executeUpdate();
			updateSQL.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close the statement and results and connection
		}
		return isUpdated;
	}

	/**
	 * @param insertSQL
	 * @param object
	 * @throws SQLException 
	 */
	abstract void setUpdateValues(PreparedStatement insertSQL, T object) throws SQLException;

	/**
	 * @return
	 */
	abstract String getUpdateSQL();

	public boolean delete(T object) {
		String deleteQuery = getDeleteQuery(object);
		boolean result = executeDeleteQuery(deleteQuery, object);
		return result;
	}
	
	/**
	 * Actual deletion.
	 * @param deleteQuery
	 * @return
	 */
	private boolean executeDeleteQuery(String deleteQuery, T object) {
		PreparedStatement deleteSQL = null;
		try {
			Connection connection = this.getDBConnection();
			deleteSQL = connection.prepareStatement(deleteQuery);
			
			setDeleteId(deleteSQL, object);
			
			deleteSQL.executeUpdate();
			deleteSQL.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close the statement and results and connection
		}
		return false;
	}

	/**
	 * Just needs to set an ID.
	 * @param deleteSQL
	 * @param object
	 */
	abstract void setDeleteId(PreparedStatement deleteSQL, T object) 
			throws SQLException;

	/**
	 * Construction of the query that deletes DB table row
	 * @param object
	 * @return
	 */
	abstract String getDeleteQuery(T object);

	@Override
	public T getById(UUID id) {
		String getById = prepareGetByIDQuery(id);
		T result = executeGetByID(getById);
		return result;
	}

	/**
	 * Output string should be a full query with no parameters
	 * @return
	 */
	abstract String prepareGetByIDQuery(UUID id);

	/**
	 * Getting by id is pretty much the same ass getting all, just by id
	 * there should by only one result.
	 * 
	 * This method cheats a bit because it takes just one result if there are 
	 * more. But there should be no such situations.
	 * 
	 * @param getById
	 * @return
	 */
	private T executeGetByID(String getById) {
		List<T> all = executeloadAll(getById);
		return all.get(0);
	}

	@Override
	public List<T> loadAll() {
		String selectAllQuery = getSelectAllQuery();
		return executeloadAll(selectAllQuery);
	}
	
	abstract String getSelectAllQuery();

	/* (non-Javadoc)
	 * @see dao.IDAO#save(java.lang.Object)
	 */
	@Override
	public boolean save(T object) {
		Boolean isSaved = executeSave(
				prepareSaveQuery(object), 
				prepareColumnNames(), 
				object);
		
		return isSaved;
	}
	
	abstract String[] prepareColumnNames();

	/**
	 * This method executes the save query
	 * @param saveQuery
	 * @return
	 */
	private Boolean executeSave(String saveQuery, String[] columnNames, 
			T entity) {
		Boolean isSaved = Boolean.FALSE;
		PreparedStatement insertSQL = null;
		try {
			Connection connection = this.getDBConnection();
			insertSQL = connection.prepareStatement(saveQuery, columnNames);
			
			setValues(insertSQL, entity);
			
			insertSQL.executeUpdate();
			insertSQL.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close the statement and results and connection
		}
		return isSaved;
	}

	abstract void setValues(PreparedStatement insertSQL, T object) 
			throws SQLException;

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
	List<T> executeloadAll(String query) {
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
		} finally {
			
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
	

	@Override
	public List<T> getAllByKey(T key) {
		String query = getSelectByKeyQuery(key);
		List<T> resultList = null;
		try {
			PreparedStatement stmt = getDBConnection().prepareStatement(query);
			setGetAllByKeyQueryParameters(stmt, key);
			ResultSet results = stmt.executeQuery();
			// build list of objects found by key
			resultList = createResultList(results);
			results.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// check for null, just in case if nothing was selected
		if (null == resultList) {
			resultList = new ArrayList<T>();
		}
		return resultList;
	}

	/**
	 * Every DAO must know what is its key.
	 * @param stmt
	 * @param key
	 */
	abstract void setGetAllByKeyQueryParameters(PreparedStatement stmt, T key)
	throws SQLException;

	/**
	 * DAO implementation knows what is select by key query.
	 * @param key
	 * @return
	 */
	abstract String getSelectByKeyQuery(T key);

}
