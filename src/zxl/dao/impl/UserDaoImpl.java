package zxl.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import zxl.dao.IUserDao;
import zxl.modals.User;

@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {
	
	static final String tableName = "zxl_ts_user";
	
	static final String[] columns = {"ID", "NAME", "ACCOUNT", "PASSWORD", "IS_ADMIN"};

	@Override
	public User save(User user) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.insertSQL(tableName, columns);
			state = this.getPreparedStmt(sql.toString());
			state.setString(1, user.getId());
			state.setString(2, user.getName());
			state.setString(3, user.getAccount());
			state.setString(4, user.getPassword());
			state.setString(5, user.getIsAdmin());
			state.executeUpdate();
			return this.getById(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("用户保存错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

	@Override
	public void delete(User user) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.deleteSql(tableName);
			sql.append(" AND ID = '" + user.getId() + "'");
			state = this.getPreparedStmt(sql.toString());
			state.executeUpdate();
		} catch (Exception e) {
			throw new Exception("用户删除错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

	@Override
	public Collection<User> get(User user) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.getSql(tableName);
			if (user.getId() != null && user.getId().trim().length() > 0) {
				sql.append(" AND ID = '" + user.getId() + "'");
			}
			if (user.getName() != null && user.getName().trim().length() > 0) {
				sql.append(" AND NAME = '" + user.getName() + "'");
			}
			if (user.getAccount() != null && user.getAccount().trim().length() > 0) {
				sql.append(" AND ACCOUNT = '" + user.getAccount() + "'");
			}
			if (user.getPassword() != null && user.getPassword().trim().length() > 0) {
				sql.append(" AND PASSWORD = '" + user.getPassword() + "'");
			}
			if (user.getIsAdmin() != null && user.getIsAdmin().trim().length() > 0) {
				sql.append(" AND IS_ADMIN = '" + user.getIsAdmin() + "'");
			}
			state = this.getPreparedStmt(sql.toString());
			ResultSet rs = state.executeQuery();
			return rsToUser(rs);
		} catch (Exception e) {
			throw new Exception("用户查询错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

	@Override
	public User getById(String id) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.getSql(tableName);
			sql.append(" AND ID = ? ");
			state = this.getPreparedStmt(sql.toString());
			state.setString(1, id);
			ResultSet rs = state.executeQuery();
			return rsToUser(rs).iterator().next();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("用户查询错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}
	
	private Collection<User> rsToUser(ResultSet rs) throws Exception {
		Collection<User> users = new ArrayList<>();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setAccount(rs.getString("ACCOUNT"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setIsAdmin(rs.getString("IS_ADMIN"));
			users.add(user);
		}
		return users;
	}

	@Override
	public User update(User user) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.updateSQL(tableName, columns);
			state = this.getPreparedStmt(sql.toString());
			state.setString(1, user.getId());
			state.setString(2, user.getName());
			state.setString(3, user.getAccount());
			state.setString(4, user.getPassword());
			state.setString(5, user.getIsAdmin());
			state.setString(6, user.getId());
			state.executeUpdate();
			return this.getById(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("用户修改错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

}
