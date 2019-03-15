package zxl.dao;

import java.util.Collection;

import zxl.modals.User;

public interface IUserDao {
	
	public User save(User user) throws Exception;
	
	public User update(User user) throws Exception;
	
	public void delete(User user)  throws Exception;
	
	public Collection<User> get(User user)  throws Exception;
	
	public User getById(String id) throws Exception;

}
