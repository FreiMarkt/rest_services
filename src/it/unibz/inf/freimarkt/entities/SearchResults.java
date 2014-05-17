package it.unibz.inf.freimarkt.entities;

import java.util.List;
import java.util.UUID;

/**
 * @author Dainius Jocas
 *
 */
public class SearchResults {

	private List<UUID> resultUUID; 
	/*
	 * Object construction
	 */
	private SearchResults() {}
	public static SearchResults newInstance() {
		return new SearchResults();
	}
	/**
	 * @return the resultUUID
	 */
	public List<UUID> getResultUUID() {
		return resultUUID;
	}
	/**
	 * @param resultUUID the resultUUID to set
	 */
	public void setResultUUID(List<UUID> resultUUID) {
		this.resultUUID = resultUUID;
	}
	
}
