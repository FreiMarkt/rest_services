package it.unibz.inf.freimarkt.entities;

/**
 * This enum stores names of the columns of the MEMBER table.
 * 
 * 
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
public enum MemberColumns {

	/*
	 * Constants
	 */
	ID("memberid"),
	FIRSTNAME("firstname"),
	LASTNAME("lastname"),
	USERNAME("username"),
	PPASWORD("ppassword"),
	AGE("age"),
	GENDER("gender"),
	ADDRESS("address"),
	CITY("city"),
	COUNTRY("country"),
	EMAIL("email"),
	PHONENUMBER("phonenumber"),
	PAYMENTSTATUS("paymentstatus"),
	FIFTYFIVEMEMBER("fiftyfivemember"),
	POSTALCODE("postalcode"),
	BIRTHDAY("birthday"),
	ROLEID("roleid");

	private String columnName;

	// Constructor
	MemberColumns(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the data
	 */
	public String getColumnName() {
		return this.columnName;
	}

	/**
	 * @param columnName the data to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}
