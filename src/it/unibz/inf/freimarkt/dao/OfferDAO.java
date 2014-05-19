package it.unibz.inf.freimarkt.dao;

import it.unibz.inf.freimarkt.dao.dbController.IDBConnectionPool;
import it.unibz.inf.freimarkt.entities.Member;
import it.unibz.inf.freimarkt.entities.OfferObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Dainius Jocas
 *
 */
public class OfferDAO extends AbstractDAO<OfferObject> implements IDAO<OfferObject> {
	
	/**
	 * @param dbConnectionPool
	 */
	OfferDAO(IDBConnectionPool dbConnectionPool) {
		super(dbConnectionPool);
	}
	
	public static OfferDAO newInstance(IDBConnectionPool dbConnectionPool) {
		return new OfferDAO(dbConnectionPool);
	}

	private String SELECT_ALL = "SELECT category, subcategory, city, "
			+ "description, priceinhours, registrationtime, goods, "
			+ "services FROM offers;";
	
	private String INSERT = "INSERT INTO offers (category, subcategory, city, "
			+ "description, priceinhours, registrationtime, goods, "
			+ "services) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setValues(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setValues(PreparedStatement insertSQL, OfferObject offer)
			throws SQLException {
		insertSQL.setString(1, offer.getCategory());
		insertSQL.setString(2, offer.getSubcategory());
		insertSQL.setString(3, offer.getCity());
		insertSQL.setString(4, offer.getDescription());
		insertSQL.setString(5, offer.getPrice());
		insertSQL.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
		insertSQL.setBoolean(7, offer.isGoods());
		insertSQL.setBoolean(8, offer.isServices());
	}
	
	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#createResultList(java.sql.ResultSet)
	 */
	@Override
	List<OfferObject> createResultList(ResultSet results) {
		List<OfferObject> offers = new ArrayList<OfferObject>();
		
		// iterate through result set and create a PassiveMember object
		// out of every result set entry
		try {
			while (results.next()) {
				OfferObject offer = OfferObject.newInstance();
				
				offer.setCategory(results.getString("category")); 
				offer.setSubcategory(results.getString("subcategory"));
				offer.setCity(results.getString("city"));
				offer.setDescription(results.getString("description"));
				offer.setPrice(results.getString("priceinhours"));
				offer.setCity(results.getString("city"));
				offer.setGoods(results.getBoolean("goods"));
				offer.setServices(results.getBoolean("services"));
				
				offers.add(offer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offers;
	}
	
	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setDeleteId(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setDeleteId(PreparedStatement deleteSQL, OfferObject object)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getDeleteQuery(java.lang.Object)
	 */
	@Override
	String getDeleteQuery(OfferObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#prepareGetByIDQuery(java.util.UUID)
	 */
	@Override
	String prepareGetByIDQuery(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getSelectAllQuery()
	 */
	@Override
	String getSelectAllQuery() {
		return this.SELECT_ALL;
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#prepareColumnNames()
	 */
	@Override
	String[] prepareColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#prepareSaveQuery(java.lang.Object)
	 */
	@Override
	String prepareSaveQuery(OfferObject OfferObject) {
		return this.INSERT;
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setGetAllByKeyQueryParameters(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setGetAllByKeyQueryParameters(PreparedStatement stmt, OfferObject key)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getSelectByKeyQuery(java.lang.Object)
	 */
	@Override
	String getSelectByKeyQuery(OfferObject key) {
		// TODO Auto-generated method stub
		return null;
	}

}
