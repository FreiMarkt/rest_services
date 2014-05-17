package it.unibz.inf.freimarkt.entities;

import java.util.UUID;

/**
 * Placeholder for the offer object.
 * @author Dainius Jocas
 *
 */
public class OfferObject {
	
	private boolean goods;
	private boolean services;
	private String category;
	private String subcategory;
	private String city;
	private String description;
	private String price;
	private UUID memberId;
	
	private OfferObject() {}
	public static OfferObject newInstance() {
		return new OfferObject();
	}
	/**
	 * @return the goods
	 */
	public boolean isGoods() {
		return goods;
	}
	/**
	 * @param goods the goods to set
	 */
	public void setGoods(boolean goods) {
		this.goods = goods;
	}
	/**
	 * @return the services
	 */
	public boolean isServices() {
		return services;
	}
	/**
	 * @param services the services to set
	 */
	public void setServices(boolean services) {
		this.services = services;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the subcategory
	 */
	public String getSubcategory() {
		return subcategory;
	}
	/**
	 * @param subcategory the subcategory to set
	 */
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the memberId
	 */
	public UUID getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

}
