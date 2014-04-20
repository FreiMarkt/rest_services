package dao;

import java.util.List;

/**
 * This is the main interface for the data persistence layer.
 * It used Java generics, therefore it might make easier to implement the
 * whole thing.
 * 
 * DAO should allow to perform CRUD operations. More specified interfaces
 * should add specified method, e.g. UserDAO should specify a method to get
 * contacts of the user or smth like this.
 * @author Dainius Jocas
 *
 */
public interface IDAO<T> {

	/**
	 * Retrieves all objects of type T from the persistence layer.
	 * Implementation should never return null.
	 * @return
	 */
	List<T> loadAll();
	
	/**
	 * Saves an object of type T to the persistence layer.
	 * @param object
	 * @return
	 */
	boolean save(T object);
	
	/**
	 * Updates record of the object saved in the persistence layer.
	 * @param object
	 * @return
	 */
	boolean update(T object);
	
	/**
	 * Deletes an object from the persistence layer.
	 * @param object
	 * @return
	 */
	boolean delete(T object);
	
	/**
	 * Finds an object in the the persistence layer by a UUID.
	 * @param id
	 * @return
	 */
	T getById(String id);
	
}
