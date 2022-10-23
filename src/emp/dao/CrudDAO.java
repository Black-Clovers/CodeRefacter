package emp.dao;

public interface CrudDAO<T, ID> extends SuperDAO {
	public boolean save(T t) throws Exception;

	public boolean update(T t) throws Exception;

	public boolean delete(ID id) throws Exception;

	public T getByID(ID id) throws Exception;

	public java.util.List<T> getAll() throws Exception;
}
