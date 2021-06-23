import { vmGame, vmGameList } from "src/app/conversion/model";


export interface GameState {
    currentGameList?: vmGameList;
    currentGame: vmGame;
}

export function getDefaultGameState(): GameState {
    return {
        currentGameList: EMPTY_GAME_LIST,
        currentGame: null
    };
}

const EMPTY_GAME_LIST: vmGameList = {
    games: []
}

export const initGameState: GameState = {
    currentGameList: EMPTY_GAME_LIST,
    currentGame: null
};