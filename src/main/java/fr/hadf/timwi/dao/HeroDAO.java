package fr.hadf.timwi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.hadf.timwi.entity.HeroEntity;
import fr.hadf.timwi.util.Constants;

@Repository
public class HeroDAO {
	
	@Autowired
	private EntityManager em;

	public List<HeroEntity> getList(int page) {
		TypedQuery<HeroEntity> query = em.createQuery("from HeroEntity", HeroEntity.class);
		query.setFirstResult(page * Constants.PAGE_SIZE);
		query.setMaxResults(Constants.PAGE_SIZE);
		
		return query.getResultList();
	}
	
	public HeroEntity getHeroById(long id) {
		return em.find(HeroEntity.class, id);
	}

}
