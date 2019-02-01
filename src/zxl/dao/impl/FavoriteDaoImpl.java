package zxl.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import zxl.dao.IFavoriteDao;
import zxl.modals.Favorite;

@Repository
public class FavoriteDaoImpl extends BaseDao implements IFavoriteDao {

	static final String tableName = "zxl_ts_favorite";

	static final String[] columns = { "ID", "USER_ID", "BOOK_ID", "BOOK_TITLE", "BOOK_IMAGE", "SC_TIMESTAMP" };

	@Override
	public Favorite save(Favorite favorite) throws Exception {
		StringBuilder sql = this.insertSQL(tableName, columns);
		PreparedStatement state = this.getPreparedStmt(sql.toString());
		state.setString(1, favorite.getId());
		state.setString(2, favorite.getUserId());
		state.setString(3, favorite.getBookId());
		state.setString(4, favorite.getBookTitle());
		state.setString(5, favorite.getBookImage());
		state.setLong(6, favorite.getScTimestamp());
		state.executeUpdate();
		return this.getById(favorite.getId());
	}

	@Override
	public void delete(Favorite favorite) throws Exception {
		StringBuilder sql = this.deleteSql(tableName);
		sql.append(" AND ID = '" + favorite.getId() + "'");
		PreparedStatement stat = this.getPreparedStmt(sql.toString());
		stat.executeUpdate();
	}

	@Override
	public Collection<Favorite> get(Favorite favorite) throws Exception {
		StringBuilder sql = this.getSql(tableName);
		if (favorite.getId() != null && favorite.getId().trim().length() > 0) {
			sql.append(" AND ID = '" + favorite.getId() + "'");
		}
		if (favorite.getUserId() != null && favorite.getUserId().trim().length() > 0) {
			sql.append(" AND USER_ID = '" + favorite.getUserId() + "'");
		}
		if (favorite.getUserName() != null && favorite.getUserName().trim().length() > 0) {
			sql.append(" AND USER_NAME = '" + favorite.getUserName() + "'");
		}
		if (favorite.getBookId() != null && favorite.getBookId().trim().length() > 0) {
			sql.append(" AND BOOK_ID = '" + favorite.getBookId() + "'");
		}
		if (favorite.getBookTitle() != null && favorite.getBookTitle().trim().length() > 0) {
			sql.append(" AND BOOK_TITLE = '" + favorite.getBookTitle() + "'");
		}
		if (favorite.getBookImage() != null && favorite.getBookImage().trim().length() > 0) {
			sql.append(" AND BOOK_IMAGE = '" + favorite.getBookImage() + "'");
		}
		if (favorite.getScTimestamp() != null) {
			sql.append(" AND SC_TIMESTAMP = '" + favorite.getScTimestamp() + "'");
		}
		PreparedStatement stat = this.getPreparedStmt(sql.toString());
		ResultSet rs = stat.executeQuery();
		return rsToFavorite(rs);
	}

	@Override
	public Favorite getById(String id) throws Exception {
		StringBuilder sql = this.getSql(tableName);
		sql.append(" AND ID = ? ");
		PreparedStatement state = this.getPreparedStmt(sql.toString());
		state.setString(1, id);
		ResultSet rs = state.executeQuery();
		return rsToFavorite(rs).iterator().next();
	}
	
	private Collection<Favorite> rsToFavorite(ResultSet rs) throws Exception {
		Collection<Favorite> favorites = new ArrayList<>();
		while(rs.next()) {
			Favorite favorite = new Favorite();
			favorite.setId(rs.getString("ID"));
			favorite.setUserId(rs.getString("USER_ID"));
			favorite.setBookId(rs.getString("BOOK_ID"));
			favorite.setBookTitle(rs.getString("BOOK_TITLE"));
			favorite.setBookImage(rs.getString("BOOK_IMAGE"));
			favorite.setUserName(rs.getString("USER_NAME"));
			favorite.setScTimestamp(rs.getLong("SC_TIMESTAMP"));
			favorites.add(favorite);
		}
		return favorites;
	}

}
