package fr.hadf.timwi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hadf.timwi.entity.HeroEntity;
import fr.hadf.timwi.model.ResponseModel;
import fr.hadf.timwi.service.IHeroService;
import fr.hadf.timwi.util.Constants;

@RestController
public class HeroController {
	
	@Autowired
	private IHeroService heroService;
	
	@RequestMapping("/hero/list")
	public ResponseModel<HeroEntity> getList(
			@RequestParam(required=false) Integer page) {
		
		List<HeroEntity> list = heroService.getList(page);
		return new ResponseModel<>(list);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseModel<Void> errorHandler(Exception e) {
		String msg = e.getMessage();
		if (StringUtils.isEmpty(msg)) {
			msg = Constants.DEFAULT_ERROR_MESSAGE;
		}
		return new ResponseModel<>(msg);
	}

}
