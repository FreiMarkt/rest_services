package it.unibz.inf.freimarkt.dao;

import it.unibz.inf.freimarkt.dao.dbController.IDBConnectionPool;
import it.unibz.inf.freimarkt.entities.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Controller to deal with PassiveMember objects.
 * @author Dainius Jocas
 *
 */
public class MemberDAO extends AbstractDAO<Member> {

	private final String SELECT_ALL_COLUMNS = 
			"SELECT memberid, firstname, lastname, ppassword, gender, address, "
			+ "city, country, email, phonenumber, paymentstatus, "
			+ "fiftyfivemember, postalcode, birthday, roleid FROM member";
	
	private String WHERE_BY_ID = " WHERE memberid=?";
	
	private final String INSERT_TO_ALL =
			"INSERT INTO member(firstname, lastname, ppassword, gender, "
			+ "address, city, country, email, phonenumber, postalcode, "
			+ "birthday) VALUES (?, ?, ?, ?, "
			+ "?, ?, ?, ?, "
			+ "?, ?, ?);";
	
	private String LOGIN_CLAUSE = " WHERE ppassword=? and email=?";
	
	private final String UPDATE_EMAIL = "UPDATE member SET email=? WHERE memberid=?;";
	
	
	private final String UPDATE = 
			"UPDATE member SET firstname=?"
			+ ", lastname=?"
			+ ", birthday=?"
			+ ", gender=?"
			+ ", phonenumber=?"
			+ ", address=?"
			+ " WHERE memberid=?;";
	
	private final String DELETE_MEMBER_BY_ID = 
			"delete from member where memberid=?;";
			

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setUpdateValues(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setUpdateValues(PreparedStatement updateSQL, Member member) throws SQLException {
		updateSQL.setString(1, member.getFirstname());
		updateSQL.setString(2, member.getLastname());
		updateSQL.setDate(3, member.getBirthday());
		updateSQL.setString(4, member.getGender());
		updateSQL.setString(5, member.getPhonenumber());
		updateSQL.setString(6, member.getAddress());
		updateSQL.setObject(7, UUID.fromString(member.getMemberid()));
	}
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
				
				member.setMemberid(results.getString("memberid")); 
				member.setFirstname(results.getString("firstname"));
				member.setLastname(results.getString("lastname"));
				member.setPpassword(results.getString("ppassword"));
				member.setAddress(results.getString("address"));
				member.setCity(results.getString("city"));
				member.setGender(results.getString("gender"));
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
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setDeleteId(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setDeleteId(PreparedStatement deleteSQL, Member object)
			throws SQLException {
		deleteSQL.setObject(1, UUID.fromString(object.getMemberid()));
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getDeleteQuery(java.lang.Object)
	 */
	@Override
	String getDeleteQuery(Member object) {
		return this.DELETE_MEMBER_BY_ID;
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#prepareGetByIDQuery(java.util.UUID)
	 */
	@Override
	String prepareGetByIDQuery(UUID id) {
		return this.SELECT_ALL_COLUMNS.
				concat(" WHERE memberid=").
				concat("'").
				concat(id.toString()).
				concat("'").
				concat(";");
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getSelectAllQuery()
	 */
	@Override
	String getSelectAllQuery() {
		return this.SELECT_ALL_COLUMNS.concat(";");
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#prepareColumnNames()
	 */
	@Override
	String[] prepareColumnNames() {
		String[] columnNames = {"firstname", "lastname", "ppassword", "gender",
				"address", "city", "country", "email", "phonenumber", "postalcode",
				"birthday"};
		return columnNames;
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setValues(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setValues(PreparedStatement insertSQL, Member member)
			throws SQLException {
		insertSQL.setString(1, member.getFirstname());
		insertSQL.setString(2, member.getLastname());
		insertSQL.setString(3, member.getPpassword());
		insertSQL.setString(4, member.getGender());
		insertSQL.setString(5, member.getAddress());
		insertSQL.setString(6, member.getCity());
		insertSQL.setString(7, member.getCountry());
		insertSQL.setString(8, member.getEmail());
		insertSQL.setString(9, member.getPhonenumber());
		insertSQL.setString(10, member.getPostalcode());
		insertSQL.setDate(11, member.getBirthday());
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setGetAllByKeyQueryParameters(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setGetAllByKeyQueryParameters(PreparedStatement stmt, Member key)
			throws SQLException {
		if (null != key.getMemberid()) {
			stmt.setObject(1, UUID.fromString(key.getMemberid()));
		} else {
			stmt.setString(1, key.getPpassword());
			stmt.setString(2, key.getEmail());
		}
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getSelectByKeyQuery(java.lang.Object)
	 */
	@Override
	String getSelectByKeyQuery(Member key) {
		if (null != key.getMemberid()) {
			return this.SELECT_ALL_COLUMNS.concat(this.WHERE_BY_ID).concat(";");
		}
		return this.SELECT_ALL_COLUMNS.concat(this.LOGIN_CLAUSE).concat(";");
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getUpdateSQL()
	 */
	@Override
	String getUpdateSQL() {
		return this.UPDATE;
	}

}
