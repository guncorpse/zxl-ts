package zxl.dao;

import java.util.Collection;

import zxl.modals.Favorite;

public interface IFavoriteDao {

	public Favorite save(Favorite favorite) throws Exception;

	public void delete(Favorite favorite) throws Exception;

	public Collection<Favorite> get(Favorite favorite) throws Exception;

	public Favorite getById(String id) throws Exception;

}
