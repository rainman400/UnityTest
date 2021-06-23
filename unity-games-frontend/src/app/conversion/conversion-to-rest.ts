import { vmGame, vmImage } from "./model";
import { gameRestRsrc, imageRestRsrc } from "./restResource";


export function convertToGameRsrc(game : vmGame) : gameRestRsrc {

    let tags : string[];
    if(game.tags) {
        tags = game.tags.trim().split(',');
    }

    let ret = {
        gameId: game.id,
        category: game.category,
        title: game.title,
        subtitle: game.subtitle,
        description: game.description,
        type: game.type,
        author: game.author,
        tags: tags,
        replayBundleUrl: game.replayBundleUrl,
        duration: game.duration,
        isDownloadable: game.isDownloadable,
        isStreamable: game.isStreamable,
        version: game.version? game.version: "1.0",
        images: game.images && game.images.length > 0? game.images.map(item => convertToImageRsrc(item)) : [],
        isPremium: game.isPremium,
    } as gameRestRsrc


    return ret;
}

export function convertToImageRsrc(image : vmImage) : imageRestRsrc {
    let ret = {
        id: image.id,
        type: image.type,
        url: image.url
    } as imageRestRsrc

    return ret;
}