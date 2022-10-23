package com.hackerthon.dao;

public interface CrudDAO<T, ID> extends SuperDAO {
//
boolean save(T t) throws Exception;

	boolean update(T t) throws Exception;

	boolean delete(ID id) throws Exception;

	T getByID(ID id) throws Exception;

	java.util.List<T> getAll() throws Exception;
}
