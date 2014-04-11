package items;

import java.sql.Date;

/**
 * User item. This should have fields more less the same as the
 * database table.
 * This is a table definition for which this class stands.
 * create table Passivemember (
 * MemberID Char(15)  primary key not null, 
 * Username Char(15) not null,
 * ppassword Char(16) not null, 
 * age      Int      not null,
 * gender   bit  not null,
 * address  Char(200) not null,
 * email    Char(30)  not null, 
 * phonenumber Char(12) not null,
 * paymentStatus bit  not null, 
 * FiftyfiveMember bit  not null,
 * postalCode Char(15) not null,
 * Birthday  Datetime  not null, 
 * RoleID    Int       not null 
 * )
 * @author Dainius Jocas
 *
 */
public class PassiveMember implements IItem {
	
	/*
	 * Data fields as described in the database
	 */
	private String memberID;
	private String username;
	private String ppassword;
	private int age;
	private boolean gender;
	private String address;
	private String phonenumber;
	private boolean paymentStatus;
	private boolean fiftyfiveMember;
	private String postalCode;
	private Date birthday;
	private int roleId;
	
	public void setUserName(String userName) {
		this.username = userName;
	}
	/**
	 * Private constructor
	 */
	private PassiveMember() {}
	
	/**
	 * Static factory method.
	 * @return
	 */
	public static PassiveMember getInstance() {
		return new PassiveMember();
	}
	
	/**
	 * Override the toString method to have a nice 
	 * string representation of the object
	 */
	public String toString() {
		return this.memberID + "  " + this.username;
	}
	/**
	 * @return the memberID
	 */
	public String getMemberID() {
		return memberID;
	}
	/**
	 * @param memberID the memberID to set
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
}
