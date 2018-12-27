package fr.hadf.timwi.service;

import java.util.List;

import fr.hadf.timwi.entity.HeroEntity;

public interface IHeroService {
	
	List<HeroEntity> getList(Integer page);

}
