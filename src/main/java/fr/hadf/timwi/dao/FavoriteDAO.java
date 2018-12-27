package fr.hadf.timwi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.hadf.timwi.entity.FavoriteEntity;
import fr.hadf.timwi.entity.HeroEntity;
import fr.hadf.timwi.util.Constants;

@Repository
public class FavoriteDAO {
	
	@Autowired
	private EntityManager em;
	
	public List<FavoriteEntity> getList(int page) {
		TypedQuery<FavoriteEntity> query = em.createQuery("from FavoriteEntity", FavoriteEntity.class);
		query.setFirstResult(page * Constants.PAGE_SIZE);
		query.setMaxResults(Constants.PAGE_SIZE);
		
		return query.getResultList();
	}

	public List<FavoriteEntity> getList(int page, String album) {
		TypedQuery<FavoriteEntity> query = em.createQuery(
				"from FavoriteEntity where album = :album", FavoriteEntity.class);
		query.setFirstResult(page * Constants.PAGE_SIZE);
		query.setMaxResults(Constants.PAGE_SIZE);
		query.setParameter("album", album);
		
		return query.getResultList();
	}
	
	public void addFavorite(HeroEntity hero, String album) {
		FavoriteEntity fav = new FavoriteEntity();
		fav.setHero(hero);
		fav.setAlbum(album);
		
		em.persist(fav);
	}

	public void deleteFavorite(Long id) {
		FavoriteEntity fav = em.find(FavoriteEntity.class, id);
		em.remove(fav);
	}

}
