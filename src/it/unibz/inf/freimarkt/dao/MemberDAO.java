package it.unibz.inf.freimarkt.dao;

import it.unibz.inf.freimarkt.dao.dbController.IDBConnectionPool;
import it.unibz.inf.freimarkt.entities.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller to deal with PassiveMember objects.
 * @author Dainius Jocas
 *
 */
public class MemberDAO extends AbstractDAO<Member> {

	private final String SELECT_ALL_COLUMNS = 
			"SELECT memberid, firstname, lastname, username,"
			+ " ppassword, age, gender, address, city, country, email,"
			+ " phonenumber, paymentstatus, fiftyfivemember,"
			+ " postalcode, birthday, roleid FROM member;";
	
	private final String INSERT_TO_ALL =
			"INSERT INTO member(memberid, firstname, lastname, username, "
			+ "ppassword, age, gender, address, city, country, email, "
			+ "phonenumber, paymentstatus, fiftyfivemember, postalcode, "
			+ "birthday, roleid) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private final String GET_MEMBER_BY_EMAIL =
			"SELECT memberid, firstname, lastname, username,"
			+ " ppassword, age, gender, address, city, country, email,"
			+ " phonenumber, paymentstatus, fiftyfivemember,"
			+ " postalcode, birthday, roleid FROM member WHERE email[1]=?;";
	
	private final String UPDATE_EMAIL = "UPDATE member SET email=? WHERE memberid=?;";
	
	private final String DELETE_MEMBER_BY_ID = 
			"delete from member where memberid[1]=?;";
			
	/**
	 * Inherited constructor.
	 * @param dbConnectionPool
	 */
	MemberDAO(IDBConnectionPool dbConnectionPool) {
		super(dbConnectionPool);
	}
	
	/*
	 * Factory method.
	 */
	public static MemberDAO getInstance(
			IDBConnectionPool dbConnectionPool) {
		return new MemberDAO(dbConnectionPool);
	}
	

	/* (non-Javadoc)
	 * @see dao.IDAO#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Member object) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see dao.IDAO#loadAll()
	 */
	@Override
	public List<Member> loadAll() {
		return executeLoadAll(SELECT_ALL_COLUMNS);
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#createResultList(java.sql.ResultSet)
	 */
	@Override
	List<Member> createResultList(ResultSet results) {
		// initialize list of passive members with an empty array list
		List<Member> members = new ArrayList<Member>();
		
		// iterate through result set and create a PassiveMember object
		// out of every result set entry
		try {
			while (results.next()) {
				Member member = Member.getInstance();
				
				member.setMemberID(results.getString("memberid")); 
				member.setFirstname(results.getString("firstname"));
				member.setLastname(results.getString("lastname"));
				member.setUsername(results.getString("username"));
				member.setPpassword(results.getString("ppassword"));
				member.setAge(results.getInt("age"));
				member.setGender(results.getBoolean("gender"));
				member.setAddress(results.getString("address"));
				member.setCity(results.getString("city"));
				member.setCountry(results.getString("country"));
				member.setEmail(results.getString("email"));
				member.setPhonenumber(results.getString("phonenumber"));
				member.setPaymentStatus(results.getBoolean("paymentstatus"));
				member.setFiftyfivemember(results.getBoolean("fiftyfivemember"));
				member.setPostalcode(results.getString("postalcode"));
				member.setBirthday(results.getDate("birthday"));
				member.setRoleId(results.getInt("roleid"));
				
				members.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#prepareSaveQuery(java.lang.Object)
	 */
	@Override
	String prepareSaveQuery(Member object) {
		return this.INSERT_TO_ALL;
	}


	/* (non-Javadoc)
	 * @see dao.AbstractDAO#setValues(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setValues(Connection connection, PreparedStatement statement, 
			Member member) throws SQLException {
		statement.setArray(1, connection.createArrayOf("varchar", new String[]{member.getMemberID()}));
		statement.setArray(2, connection.createArrayOf("varchar", new String[]{member.getFirstname()}));
		statement.setArray(3, connection.createArrayOf("varchar", new String[]{member.getLastname()}));
		statement.setArray(4, connection.createArrayOf("varchar", new String[]{member.getUsername()}));
		statement.setArray(5, connection.createArrayOf("varchar", new String[]{member.getPpassword()}));
		statement.setInt(6, member.getAge());
		statement.setBoolean(7, member.isGender());
		statement.setString(8, member.getAddress());
		statement.setArray(9, connection.createArrayOf("varchar", new String[]{member.getCity()}));
		statement.setArray(10, connection.createArrayOf("varchar", new String[]{member.getCountry()}));
		statement.setArray(11, connection.createArrayOf("varchar", new String[]{member.getEmail()}));
		statement.setArray(12, connection.createArrayOf("varchar", new String[]{member.getPhonenumber()}));
		statement.setBoolean(13, member.isPaymentStatus());
		statement.setBoolean(14, member.isFiftyfivemember());
		statement.setArray(15, connection.createArrayOf("varchar", new String[]{member.getPostalcode()}));
		statement.setDate(16, member.getBirthday());
		statement.setInt(17, member.getRoleId());
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#getWhereQuery(java.lang.String)
	 */
	@Override
	String getWhereQuery(String id) {
		return this.GET_MEMBER_BY_EMAIL;
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#getDefaultObject()
	 */
	@Override
	Member getDefaultObject() {
		return Member.getInstance();
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#getUpdateQuery(java.lang.Object)
	 */
	@Override
	String getUpdateQuery(Member object) {
		return UPDATE_EMAIL;
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#setUpdateValues(java.sql.Connection, java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setUpdateValues(Connection connection, PreparedStatement statement,
			Member member) throws SQLException {
		// TODO (Dainius): this is just a one pair of possible updates
		statement.setArray(1, connection.createArrayOf("varchar", new String[]{member.getEmail()}));
		statement.setArray(2, connection.createArrayOf("varchar", new String[]{member.getMemberID()}));		
	}
}
