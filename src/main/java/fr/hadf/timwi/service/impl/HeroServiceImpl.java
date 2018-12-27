package fr.hadf.timwi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.hadf.timwi.dao.HeroDAO;
import fr.hadf.timwi.entity.HeroEntity;
import fr.hadf.timwi.service.IHeroService;

@Service
public class HeroServiceImpl implements IHeroService {
	
	@Autowired
	private HeroDAO heroDAO;

	@Override
	public List<HeroEntity> getList(Integer page) {
		if (page == null) {
			page = 0;
		}
		return heroDAO.getList(page);
	}
	
}
