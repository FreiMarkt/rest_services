package dao;

import items.PassiveMember;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dao.dbController.IDBConnectionPool;

/**
 * Controller to deal with PassiveMember objects.
 * @author Dainius Jocas
 *
 */
public class PassiveMemberDAO extends AbstractDAO<PassiveMember> {

	/**
	 * Inherited constructor.
	 * @param dbConnectionPool
	 */
	PassiveMemberDAO(IDBConnectionPool dbConnectionPool) {
		super(dbConnectionPool);
	}
	
	/*
	 * Factory method.
	 */
	public static PassiveMemberDAO getInstance(
			IDBConnectionPool dbConnectionPool) {
		return new PassiveMemberDAO(dbConnectionPool);
	}

	

	/* (non-Javadoc)
	 * @see dao.IDAO#update(java.lang.Object)
	 */
	@Override
	public boolean update(PassiveMember object) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see dao.IDAO#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(PassiveMember object) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see dao.IDAO#loadAll()
	 */
	@Override
	public List<PassiveMember> loadAll() {
		
		// initialize list of passive members
		List<PassiveMember> listOfPassiveMembers = null;
		
		try {
			// get connection to the database
			// parent class knows how to do it
			Connection connection = getDBConnection();
			
			// create Statement object
			Statement statement = connection.createStatement();
			
			// SQL statement which selects everything from passivemember table
			String sql = "select * from passivemember;";
			
			// get a result from of query execution
			ResultSet resultSet = statement.executeQuery(sql);
			
			// convert result set to a List<PassiveMember>
			listOfPassiveMembers = createResultList(resultSet);
			
			// close resources
			resultSet.close();
			statement.close();
			// TODO: connection should not be closed with a proper 
			// pool implementation
			connection.close(); 
		} catch (SQLException e) {
			System.out.println("sql exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// return the list
		return listOfPassiveMembers;
	}

	/* (non-Javadoc)
	 * @see dao.IDAO#getById(java.util.UUID)
	 */
	@Override
	public PassiveMember getById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#createResultList(java.sql.ResultSet)
	 */
	@Override
	List<PassiveMember> createResultList(ResultSet results) {
		// initialize list of passive members with an empty array list
		List<PassiveMember> passiveMembers = new ArrayList<PassiveMember>();
		
		// iterate through result set and create a PassiveMember object
		// out of every result set entry
		try {
			while (results.next()) {
				PassiveMember pm = PassiveMember.getInstance();
				passiveMembers.add(pm);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passiveMembers;
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#prepareSaveQuery(java.lang.Object)
	 */
	@Override
	String prepareSaveQuery(PassiveMember object) {
		// TODO Auto-generated method stub
		return null;
	}

}
