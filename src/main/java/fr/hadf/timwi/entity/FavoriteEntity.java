package fr.hadf.timwi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FavoriteEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private HeroEntity hero;
	
	private String album;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public HeroEntity getHero() {
		return hero;
	}
	public void setHero(HeroEntity hero) {
		this.hero = hero;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}

}
