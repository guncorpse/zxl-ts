package zxl.service;

import java.util.Collection;

import zxl.modals.Favorite;

public interface IFavoriteService {

	public Favorite save(Favorite favorite) throws Exception;

	public Favorite update(Favorite favorite) throws Exception;

	public void delete(Favorite favorite) throws Exception;

	public Collection<Favorite> get(Favorite favorite) throws Exception;

	public Favorite get(String id) throws Exception;

}
