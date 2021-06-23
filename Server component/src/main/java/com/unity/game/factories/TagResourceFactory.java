package com.unity.game.factories;

import java.util.List;

import com.unity.game.model.Tag;
import com.unity.game.resources.TagListRsrc;
import com.unity.game.resources.TagRsrc;

public interface TagResourceFactory {
    public TagRsrc populate(Tag tagDto, TagRsrc resource) ;
    public Tag applyModel(Tag tagDto, TagRsrc resource);

    public TagListRsrc populateTagsList(List<Tag> tagListDto, TagListRsrc resource);
}
