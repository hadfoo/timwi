package fr.hadf.timwi.service;

import java.util.List;

import fr.hadf.timwi.entity.FavoriteEntity;

public interface IFavoriteService {
	
	List<FavoriteEntity> getList(Integer page, String album);
	void addFavorite(Long id, String album);
	void deleteFavorite(Long id);

}
