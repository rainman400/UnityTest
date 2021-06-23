package com.unity.game.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tag")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer tagId;
	private String tagText;
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Games game;

	public Integer getTagId() {
		return tagId;
	}

	public String getTagText() {
		return tagText;
	}
	public void setTagText(String tagText) {
		this.tagText = tagText;
	}

	public Games getGame() {
		return game;
	}
	public void setGame(Games game){
		this.game = game;
	}

}
