package it.unibz.inf.freimarkt.entities;

/**
 * @author Dainius Jocas
 *
 */
public class SearchObject {
	private boolean goods;
	private boolean services;
	private String category;
	private String subcategory;
	private String city;
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
	
	/*
	 * Private constructor
	 */
	private SearchObject() {}
	/**
	 * @return new instance of this class
	 */
	public static SearchObject newInstance() {
		return new SearchObject();
	}
}
