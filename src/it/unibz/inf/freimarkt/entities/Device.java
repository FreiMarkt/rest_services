package it.unibz.inf.freimarkt.entities;

import java.sql.Date;

/**
 * This class acts as a wrapper of the devices table in the application server.
 * 
 * Table definition:
CREATE TABLE devices
(
  deviceid uuid NOT NULL DEFAULT uuid_generate_v4(),
  inserttime timestamp without time zone NOT NULL DEFAULT now(),
  deviceregistrationid character varying(100),
  isactive boolean DEFAULT false,
  CONSTRAINT "DevicesPK" PRIMARY KEY (deviceid)
)
 * @author Dainius Jocas
 *
 */
public class Device {

	/*
	 * Private fields
	 */
	private String deviceid; // string representation of UUID for simplicity
	private Date inserttime;
	private String deviceregistrationid;
	private boolean isactive;
	
	/*
	 * Private constructor
	 */
	private Device() {}
	/**
	 * Static factory method that creates a new instance 
	 * @return
	 */
	public static Device newInstance() {
		return new Device();
	}
	/**
	 * @return the deviceid
	 */
	public String getDeviceid() {
		return deviceid;
	}
	/**
	 * @param deviceid the deviceid to set
	 */
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	/**
	 * @return the inserttime
	 */
	public Date getInserttime() {
		return inserttime;
	}
	/**
	 * @param inserttime the inserttime to set
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * @return the deviceregistrationid
	 */
	public String getDeviceregistrationid() {
		return deviceregistrationid;
	}
	/**
	 * @param deviceregistrationid the deviceregistrationid to set
	 */
	public void setDeviceregistrationid(String deviceregistrationid) {
		this.deviceregistrationid = deviceregistrationid;
	}
	/**
	 * @return the isactive
	 */
	public boolean isIsactive() {
		return isactive;
	}
	/**
	 * @param isactive the isactive to set
	 */
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
}
