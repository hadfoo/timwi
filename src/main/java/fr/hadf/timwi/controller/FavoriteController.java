package fr.hadf.timwi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hadf.timwi.entity.FavoriteEntity;
import fr.hadf.timwi.model.ResponseModel;
import fr.hadf.timwi.service.IFavoriteService;
import fr.hadf.timwi.util.Constants;

@RestController
public class FavoriteController {
	
	@Autowired
	private IFavoriteService favoriteService;
	
	@RequestMapping("/favorite/list")
	public ResponseModel<FavoriteEntity> getList(
			@RequestParam(required=false) Integer page, 
			@RequestParam(required=false) String album) {
		
		List<FavoriteEntity> list = favoriteService.getList(page, album);
		return new ResponseModel<>(list);
	}
	
	@RequestMapping(value="/favorite/add/{album}/{id}", method=RequestMethod.PUT)
	public ResponseModel<Void> addFavorite(
			@PathVariable String album,
			@PathVariable Long id) {
		
		favoriteService.addFavorite(id, album);
		return new ResponseModel<>();
	}

	@RequestMapping(value="/favorite/delete/{id}", method=RequestMethod.DELETE)
	public ResponseModel<Void> deleteFavorite(
			@PathVariable Long id) {
		
		favoriteService.deleteFavorite(id);
		return new ResponseModel<>();
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
