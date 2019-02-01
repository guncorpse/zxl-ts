package zxl.service;

import java.util.Collection;

import zxl.modals.User;

public interface IUserService {
	
	public User save(User user) throws Exception;

	public User update(User user) throws Exception;

	public void delete(User user) throws Exception;

	public Collection<User> get(User user) throws Exception;

	public User get(String id) throws Exception;
	
	public User login(User user) throws Exception;

}
