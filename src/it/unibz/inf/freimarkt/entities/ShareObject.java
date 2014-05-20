package it.unibz.inf.freimarkt.entities;

import java.util.UUID;

/**
 * @author Dainius Jocas
 *
 */
public class ShareObject {

	private UUID id;
	private String hoursShared;
	
	private ShareObject() {}
	
	public static ShareObject newInstance() {
		return new ShareObject();
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the hoursShared
	 */
	public String getHoursShared() {
		return hoursShared;
	}

	/**
	 * @param hoursShared the hoursShared to set
	 */
	public void setHoursShared(String hoursShared) {
		this.hoursShared = hoursShared;
	}
}
