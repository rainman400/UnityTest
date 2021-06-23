import { Action } from "@ngrx/store";
import { AddGameErrorAction, ADD_GAME_ERROR, GetGameSuccessAction, GET_GAME_ERROR, GET_GAME_SUCCESS, LoadGameListSuccessAction, LOAD_GAME_LIST_ERROR, LOAD_GAME_LIST_SUCCESS } from "./game.actions";
import { GameState, getDefaultGameState } from "./game.state";


export function gamesReducer( state: GameState = getDefaultGameState(), action: Action): GameState {
    switch (action.type) {

        case LOAD_GAME_LIST_SUCCESS: {
            const typedAction = <LoadGameListSuccessAction> action;
            return {...state, currentGameList: typedAction.payload.gameList};
        }

        case GET_GAME_SUCCESS : {
            const typedAction = <GetGameSuccessAction> action;
            return {...state, currentGame: typedAction.payload.game};
        }

        default: {
            return state;
        }
    }
}