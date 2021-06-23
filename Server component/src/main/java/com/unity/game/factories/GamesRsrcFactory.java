package com.unity.game.factories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.unity.game.model.Games;
import com.unity.game.model.Image;
import com.unity.game.model.Tag;
import com.unity.game.resources.GamesListRsrc;
import com.unity.game.resources.GamesRsrc;
import com.unity.game.resources.ImageRsrc;

import org.springframework.stereotype.Component;

@Component
public class GamesRsrcFactory implements GameResourceFactory{
    
    @Override
    public GamesRsrc populate(Games gamesDto, GamesRsrc resource) {
        resource.setAuthor(gamesDto.getAuthor());
        resource.setCategory(gamesDto.getCategory());
        resource.setDescription(gamesDto.getDescription());
        resource.setDuration(gamesDto.getDuration());
        resource.setGameId(gamesDto.getGameId());
        resource.setIsDownloadable(gamesDto.getIsDownloadable());
        resource.setIsStreamable(gamesDto.getIsStreamable());
        resource.setReplayBundleUrl(gamesDto.getReplayBundleUrl());
        resource.setSubtitle(gamesDto.getSubtitle());
        resource.setTitle(gamesDto.getTitle());
        resource.setType(gamesDto.getType());
        resource.setVersion(gamesDto.getVersion());
        resource.setIsPremium(gamesDto.getIsPremium());

        List<String> tags = new ArrayList<>();
        if(gamesDto.getTags() != null && gamesDto.getTags().size() > 0) {
            for(Tag tag : gamesDto.getTags()){
                tags.add(tag.getTagText());
            }
        }
        resource.setTags(tags);

        List<ImageRsrc> images = new ArrayList<>();
        if(gamesDto.getImages() != null && gamesDto.getImages().size() > 0) {
            for(Image image : gamesDto.getImages()) {
                ImageRsrc imageRsrc = new ImageRsrc();
                imageRsrc.setType(image.getType());
                imageRsrc.setUrl(image.getUrl());
                images.add(imageRsrc);
            }
        }
        resource.setImages(images);
        
        
        return resource;
    }

    @Override
    public Games applyModel(Games gamesDto, GamesRsrc resource) {
        gamesDto.setAuthor(resource.getAuthor());
        gamesDto.setCategory(resource.getCategory());
        gamesDto.setDescription(resource.getDescription());
        gamesDto.setDuration(resource.getDuration());
        gamesDto.setGameId(resource.getGameId());
        gamesDto.setIsDownloadable(resource.getIsDownloadable() != null? resource.getIsDownloadable():  false);
        gamesDto.setIsStreamable(resource.getIsStreamable()!= null ? resource.getIsStreamable(): false);
        gamesDto.setReplayBundleUrl(resource.getReplayBundleUrl());
        gamesDto.setSubtitle(resource.getSubtitle());
        gamesDto.setTitle(resource.getTitle());
        gamesDto.setType(resource.getType() != null ? resource.getType() : 1);
        gamesDto.setVersion(resource.getVersion());
        gamesDto.setIsPremium(resource.getIsPremium() == null ? null : true);

        if(resource.getTags() != null && resource.getTags().size() > 0) {
            Set<Tag> tags = new HashSet<Tag>();
            for(String tagString : resource.getTags()){
                Tag tag = new Tag();
                tag.setTagText(tagString);
                tags.add(tag);
            }
            gamesDto.setTags(tags);
        }

        if(resource.getImages() != null && resource.getImages().size() > 0) {
            List<Image> images = new ArrayList<Image>();
            for(ImageRsrc imageRsrc : resource.getImages()){
                Image image = new Image();
                image.setUrl(imageRsrc.getUrl());
                image.setType(imageRsrc.getType());
                images.add(image);
            }
            gamesDto.setImages(images);
        }

        return gamesDto;
    }

    @Override
    public GamesListRsrc populateGamesList(List<Games> gamesListDto, GamesListRsrc resource) {
        List<GamesRsrc> listings = new ArrayList<>();
        for(Games game : gamesListDto) {
            GamesRsrc rsrc = new GamesRsrc();
            rsrc = populate(game,rsrc);
            listings.add(rsrc);
        }
        resource.setListings(listings);
        return resource;
    }
}
