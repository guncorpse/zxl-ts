package zxl.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zxl.dao.IFavoriteDao;
import zxl.modals.Favorite;
import zxl.service.IFavoriteService;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
	
	@Autowired
	private IFavoriteDao favoriteDao;

	@Override
	public Favorite save(Favorite favorite) throws Exception {
		favorite.setId(UUID.randomUUID().toString());
		favorite.setScTimestamp(new Date().getTime());
		return favoriteDao.save(favorite);
	}

	@Override
	public Favorite update(Favorite favorite) throws Exception {
		return null;
	}

	@Override
	public void delete(Favorite favorite) throws Exception {
		favoriteDao.delete(favorite);
	}

	@Override
	public Collection<Favorite> get(Favorite favorite) throws Exception {
		return favoriteDao.get(favorite);
	}

	@Override
	public Favorite get(String id) throws Exception {
		return favoriteDao.getById(id);
	}

}
