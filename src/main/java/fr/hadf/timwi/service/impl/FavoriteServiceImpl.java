package fr.hadf.timwi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import fr.hadf.timwi.dao.FavoriteDAO;
import fr.hadf.timwi.dao.HeroDAO;
import fr.hadf.timwi.entity.FavoriteEntity;
import fr.hadf.timwi.entity.HeroEntity;
import fr.hadf.timwi.exception.BusinessException;
import fr.hadf.timwi.service.IFavoriteService;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	@Autowired
	private HeroDAO heroDAO;

	@Override
	public List<FavoriteEntity> getList(Integer page, String album) {
		if (page == null) {
			page = 0;
		}
		if (StringUtils.isEmpty(album)) {
			return favoriteDAO.getList(page);
		}
		else {
			return favoriteDAO.getList(page, album);
		}
	}

	@Transactional(rollbackOn=Throwable.class)
	@Override
	public void addFavorite(Long id, String album) {
		HeroEntity hero = heroDAO.getHeroById(id);
		if (hero == null) {
			new BusinessException("hero.unknown");
		}
		favoriteDAO.addFavorite(hero, album);
	}

	@Transactional(rollbackOn=Throwable.class)
	@Override
	public void deleteFavorite(Long id) {
		favoriteDAO.deleteFavorite(id);
	}

}
