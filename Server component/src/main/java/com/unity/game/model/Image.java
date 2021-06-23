package com.unity.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "imageId")
	private Integer id;
	private String imageUrl;
	private Integer imageType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id")
	private Games game;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return imageType;
	}
	public void setType(Integer imageType) {
		this.imageType = imageType;
	}

	public String getUrl() {
		return imageUrl;
	}
	public void setUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Games getGame() { 
		return game;
	}

	public void setGame(Games game) {
		this.game = game;
	}

}
