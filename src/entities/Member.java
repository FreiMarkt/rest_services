package entities;

import java.sql.Date;

/**
 * User item. This should have fields more less the same as the
 * database table.
 * This is a table definition for which this class stands.
CREATE TABLE member
(
  memberid character varying(15)[] NOT NULL,
  firstname character varying(15)[] NOT NULL,
  lastname character varying(15)[] NOT NULL,
  username character varying(25)[] NOT NULL,
  ppassword character varying(16)[] NOT NULL,
  age smallint NOT NULL,
  gender boolean NOT NULL DEFAULT true,
  address text NOT NULL,
  city character varying(15)[] NOT NULL,
  country character varying(15)[] NOT NULL,
  email character varying(30)[] NOT NULL,
  phonenumber character varying(20) NOT NULL,
  paymentstatus boolean NOT NULL DEFAULT true,
  fiftyfivemember boolean NOT NULL DEFAULT true,
  postalcode character varying(15)[] NOT NULL,
  birthday date NOT NULL,
  roleid smallint NOT NULL DEFAULT 3,
  CONSTRAINT "MemberPK" PRIMARY KEY (memberid)
)
 * @author Dainius Jocas
 *
 */
public class Member implements IItem {
	
	/*
	 * Data fields as described in the database
	 */
	private String memberid;
	private String firstname;
	private String lastname;
	private String username;
	private String ppassword;
	private int age;
	private boolean gender;
	private String address;
	private String city;
	private String country;
	private String email;
	private String phonenumber;
	private boolean paymentStatus;
	private boolean fiftyfivemember;
	private String postalcode;
	private Date birthday;
	private int roleId;
	
	public void setUsername(String userName) {
		this.username = userName;
	}
	
	public String getUsername() {
		return this.username;
	}
	/**
	 * Private constructor
	 */
	private Member() {}
	
	/**
	 * Static factory method.
	 * @return
	 */
	public static Member getInstance() {
		return new Member();
	}
	
	/**
	 * Override the toString method to have a nice 
	 * string representation of the object
	 */
	public String toString() {
		return this.memberid + "  " + this.username;
	}
	/**
	 * @return the memberID
	 */
	public String getMemberID() {
		return memberid;
	}
	/**
	 * @param memberID the memberID to set
	 */
	public void setMemberID(String memberID) {
		this.memberid = memberID;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the ppassword
	 */
	public String getPpassword() {
		return ppassword;
	}
	/**
	 * @param ppassword the ppassword to set
	 */
	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public boolean isGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the paymentStatus
	 */
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	/**
	 * @return the fiftyfivemember
	 */
	public boolean isFiftyfivemember() {
		return fiftyfivemember;
	}
	/**
	 * @param fiftyfivemember the fiftyfivemember to set
	 */
	public void setFiftyfivemember(boolean fiftyfivemember) {
		this.fiftyfivemember = fiftyfivemember;
	}
	/**
	 * @return the postalcode
	 */
	public String getPostalcode() {
		return postalcode;
	}
	/**
	 * @param postalcode the postalcode to set
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
