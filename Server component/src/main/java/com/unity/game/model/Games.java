package com.unity.game.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity 
public class Games {
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer gameId;
	private String category;
	private String title;
	private String subtitle;
	private String description;
	private Integer type;
	private String author;
	private String replayBundleUrl;
	private Float duration;
	private Boolean isDownloadable;
	private Boolean isStreamable;
	private String version;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "game")
	private List<Image> images;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "game")
	private Set<Tag> tags;
	private Boolean isPremium;

	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReplayBundleUrl() {
		return replayBundleUrl;
	}
	public void setReplayBundleUrl(String replayBundleUrl) {
		this.replayBundleUrl = replayBundleUrl;
	}

	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Boolean getIsDownloadable() {
		return isDownloadable;
	}
	public void setIsDownloadable(Boolean isDownloadable) {
		this.isDownloadable = isDownloadable;
	}

	public Boolean getIsStreamable() {
		return isStreamable;
	}
	public void setIsStreamable(Boolean isStreamable) {
		this.isStreamable = isStreamable;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Boolean getIsPremium() {
		return isPremium;
	}
	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}

}
