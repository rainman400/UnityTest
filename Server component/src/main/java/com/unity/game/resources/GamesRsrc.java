package com.unity.game.resources;

import java.util.List;

public class GamesRsrc {

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
	private List<ImageRsrc> images;
	private List<String> tags;
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

	public List<ImageRsrc> getImages() {
		return images;
	}
	public void setImages(List<ImageRsrc> images) {
		this.images = images;
	}

	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Boolean getIsPremium() {
		return isPremium;
	}
	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}
}
