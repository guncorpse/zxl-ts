package zxl.dao;

import java.util.Collection;

import zxl.modals.Favorite;

public interface IFavoriteDao {

	public Favorite save(Favorite book) throws Exception;

	public void delete(Favorite book) throws Exception;

	public Collection<Favorite> get(Favorite book) throws Exception;

	public Favorite getById(String id) throws Exception;

}
