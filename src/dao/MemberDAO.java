package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dao.dbController.IDBConnectionPool;
import entities.Member;

/**
 * Controller to deal with PassiveMember objects.
 * @author Dainius Jocas
 *
 */
public class MemberDAO extends AbstractDAO<Member> {

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
	 * @see dao.IDAO#update(java.lang.Object)
	 */
	@Override
	public boolean update(Member object) {
		// TODO Auto-generated method stub
		return false;
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
		// SQL statement which selects everything from passivemember table
		String sql = "SELECT memberid, firstname, lastname, username,"
				+ " ppassword, age, gender, address, city, country, email,"
				+ " phonenumber, paymentstatus, fiftyfivemember,"
				+ " postalcode, birthday, roleid FROM member;";
		
		// initialize list of passive members
		List<Member> listOfPassiveMembers = 
				executeLoadAll(sql);
		
		// return the list
		return listOfPassiveMembers;
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAO#createResultList(java.sql.ResultSet)
	 */
	@Override
	List<Member> createResultList(ResultSet results) {
		// initialize list of passive members with an empty array list
		List<Member> passiveMembers = new ArrayList<Member>();
		
		// iterate through result set and create a PassiveMember object
		// out of every result set entry
		try {
			while (results.next()) {
				Member member = Member.getInstance();
				member.setMemberID(results.getString("memberid")); 
				member.setFirstname(results.getString("firstname"));
				member.setLastname(results.getString("lastname"));
				member.setUserName(results.getString("username"));
				member.setPpassword(results.getString("ppasword"));
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
				
				passiveMembers.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passiveMembers;
	}
	

	/* (non-Javadoc)
	 * @see dao.IDAO#getById(java.util.UUID)
	 */
	@Override
	public Member getById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see dao.AbstractDAO#prepareSaveQuery(java.lang.Object)
	 */
	@Override
	String prepareSaveQuery(Member object) {
		// TODO Auto-generated method stub
		return null;
	}

}
