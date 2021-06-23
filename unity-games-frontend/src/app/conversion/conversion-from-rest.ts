import { vmCategory, vmCategoryList, vmGame, vmGameList, vmImage } from "./model";
import { categoryRsrc, gameRestRsrc, imageRestRsrc } from "./restResource";


export function convertToGame(gameRsrc : gameRestRsrc) :vmGame {
    
    let ret: vmGame = {
        id: gameRsrc.gameId,
        category: gameRsrc.category,
        title: gameRsrc.title,
        subtitle: gameRsrc.subtitle,
        description: gameRsrc.description,
        type: gameRsrc.type,
        author: gameRsrc.author,
        replayBundleUrl: gameRsrc.replayBundleUrl,
        duration: gameRsrc.duration,
        isDownloadable: gameRsrc.isDownloadable,
        isStreamable: gameRsrc.isStreamable,
        version: gameRsrc.version,
        images: gameRsrc.images && gameRsrc.images.length > 0? gameRsrc.images.map(item => convertToImage(item)) : [],
        tags: getTagString(gameRsrc.tags),
        isPremium: gameRsrc.isPremium,
    }

    return ret;
}

function getTagString(tags: string[]) {
    let tagString: string;
    tags.forEach((item) => {
        tagString += item + ",";
    })
    return tagString && tagString.charAt(tagString.length-1) == ","? tagString.substring(0,tagString.length-2) : tagString;
}

export function convertToGameList(games: any) : vmGameList{
    
    if (games && games.length > 0) {
        return {
            games: games.map(item => convertToGame(item))
        }
    } else {
        return {
            games: []
        }
    }
}

export function convertToImage(imageRsrc: imageRestRsrc): vmImage {
    let ret: vmImage = {
        id: imageRsrc.id,
        type: imageRsrc.type,
        url: imageRsrc.url
    }

    return ret;
}


export function convertToCategoryList(categories: any) : vmCategoryList{
    if(categories && categories.length > 0) {
        return {
            categories: categories.map(item => convertToCategory(item))
        }
    } else {
        return {
            categories: []
        }
    }
}

export function convertToCategory(category: categoryRsrc) : vmCategory {
    
    let ret: vmCategory = {
        id: category.id,
        categoryText: category.categoryText
    }

    return ret;
}