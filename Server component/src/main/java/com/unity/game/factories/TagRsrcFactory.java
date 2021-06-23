package com.unity.game.factories;

import java.util.ArrayList;
import java.util.List;

import com.unity.game.model.Tag;
import com.unity.game.resources.TagListRsrc;
import com.unity.game.resources.TagRsrc;

import org.springframework.stereotype.Component;

@Component
public class TagRsrcFactory implements TagResourceFactory{

    @Override
    public TagRsrc populate(Tag tagDto, TagRsrc resource) {
        
        resource.setTagId(tagDto.getTagId());
        resource.setTagText(tagDto.getTagText());
        
        return resource;
    }

    @Override
    public Tag applyModel(Tag tagDto, TagRsrc resource) {  
        tagDto.setTagText(resource.getTagText());    
        return tagDto;
    }

    @Override
    public TagListRsrc populateTagsList(List<Tag> tagListDto, TagListRsrc resource) {
        List<TagRsrc> tags = new ArrayList<>();
        for(Tag game : tagListDto) {
            TagRsrc rsrc = new TagRsrc();
            rsrc = populate(game,rsrc);
            tags.add(rsrc);
        }
        resource.setTags(tags);
        return resource;
    }
    
}
