package com.hackerthon.dao;

public interface CrudDAO<T, ID>
		extends SuperDAO { // This is the interface class for all the DAO classes to implement methods
	//
	void save(T t) throws Exception;// This method is used to save the data to the database

	boolean update(T t) throws Exception;// This method is used to update the data in the database

	boolean delete(ID id) throws Exception;// This method is used to delete the data from the database

	T getByID(ID id) throws Exception;// This method is used to get the data from the database by id

	java.util.List<T> getAll() throws Exception;// This method is used to get all the data from the database
}
