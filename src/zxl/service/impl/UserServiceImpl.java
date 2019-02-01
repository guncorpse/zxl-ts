package zxl.service.impl;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxl.dao.IUserDao;
import zxl.modals.User;
import zxl.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public User save(User user) throws Exception {
		user.setId(UUID.randomUUID().toString());
		user.setIsAdmin("n");
		User search = new User();
		search.setAccount(user.getAccount());
		Collection<User> exist = userDao.get(search);
		if (!exist.isEmpty()) {
			throw new Exception("此账号已经存在");
		}
		return userDao.save(user);
	}

	@Override
	public User update(User user) throws Exception {
		return null;
	}

	@Override
	public void delete(User user) throws Exception {
		userDao.delete(user);;
	}

	@Override
	public Collection<User> get(User user) throws Exception {
		return userDao.get(user);
	}

	@Override
	public User get(String id) throws Exception {
		return userDao.getById(id);
	}

	@Override
	public User login(User user) throws Exception {
		User search = new User();
		search.setAccount(user.getAccount());
		Collection<User> exists = userDao.get(search);
		if (exists.isEmpty()) {
			throw new Exception("账号不存在");
		}
		User exist = exists.iterator().next();
		if (!user.getPassword().equals(exist.getPassword())) {
			throw new Exception("密码错误");
		}
		return exist;
	}

}
