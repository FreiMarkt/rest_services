package it.unibz.inf.freimarkt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import it.unibz.inf.freimarkt.dao.dbController.IDBConnectionPool;
import it.unibz.inf.freimarkt.entities.Device;

/**
 * @author Dainius Jocas
 *
 */
public class DevicesDAO extends AbstractDAO<Device> implements IDAO<Device> {

	
	private String selectAll = "SELECT deviceid, inserttime, deviceregistrationid, isactive FROM devices";
	private String insert = "insert into devices (deviceregistrationid) values (?)";
	
	/**
	 * @param dbConnectionPool
	 */
	DevicesDAO(IDBConnectionPool dbConnectionPool) {
		super(dbConnectionPool);
	}

	/**
	 * @param dbConnectionPool
	 * @return
	 */
	public static IDAO<Device> getInstance(IDBConnectionPool dbConnectionPool) {
		return new DevicesDAO(dbConnectionPool);
	}
	
	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setDeleteId(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setDeleteId(PreparedStatement deleteSQL, Device object)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getDeleteQuery(java.lang.Object)
	 */
	@Override
	String getDeleteQuery(Device object) {
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
		return this.selectAll.concat(";");
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
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setValues(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setValues(PreparedStatement insertSQL, Device object)
			throws SQLException {
		insertSQL.setString(1, object.getDeviceregistrationid());
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#prepareSaveQuery(java.lang.Object)
	 */
	@Override
	String prepareSaveQuery(Device object) {
		return this.insert.concat(";");
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#createResultList(java.sql.ResultSet)
	 * 
	 * deviceid, inserttime, deviceregistrationid, isactive
	 * 
	 */
	@Override
	List<Device> createResultList(ResultSet results) {
		List<Device> devices = new ArrayList<Device>();
		try {
			while (results.next()) {
				Device tempDevice = Device.newInstance();
				tempDevice.setDeviceid(results.getString("deviceid"));
				tempDevice.setInserttime(results.getDate("inserttime"));
				tempDevice.setDeviceregistrationid(results.getString("deviceregistrationid"));
				tempDevice.setIsactive(results.getBoolean("isactive"));
				
				devices.add(tempDevice);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return devices;
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#setGetAllByKeyQueryParameters(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	void setGetAllByKeyQueryParameters(PreparedStatement stmt, Device key)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.unibz.inf.freimarkt.dao.AbstractDAO#getSelectByKeyQuery(java.lang.Object)
	 */
	@Override
	String getSelectByKeyQuery(Device key) {
		// TODO Auto-generated method stub
		return null;
	}

}
