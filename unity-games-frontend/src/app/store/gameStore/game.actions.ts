import { Action } from "@ngrx/store";
import { errorMessage, vmGame, vmGameList } from "src/app/conversion/model";


export const LOAD_GAME_LIST = 'LOAD_GAME_LIST';
export const LOAD_GAME_LIST_SUCCESS = 'LOAD_GAME_LIST_SUCCESS';
export const LOAD_GAME_LIST_ERROR = 'LOAD_GAME_LIST_FAIL';

export const GET_GAME = 'GET_GAME';
export const GET_GAME_SUCCESS = 'GET_GAME_SUCCESS';
export const GET_GAME_ERROR = 'GET_GAME_FAIL';

export const ADD_GAME = 'ADD_GAME';
export const ADD_GAME_SUCCESS = 'ADD_GAME_SUCCESS';
export const ADD_GAME_ERROR = 'ADD_GAME_ERROR';


export interface LoadGameListAction extends Action {
    payload :{
    }
}

export interface LoadGameListSuccessAction extends Action {
    payload :{
        gameList:vmGameList;
    }
}

export interface ErrorAction extends Action {
    payload :{
        error:errorMessage;
    }
}

export function loadGameList(): LoadGameListAction {
    return {
        type: LOAD_GAME_LIST,
        payload:{}
    }
}

export function loadGameListSuccess(gameList: vmGameList): LoadGameListSuccessAction {
    return {
        type: LOAD_GAME_LIST_SUCCESS,
        payload:{
            gameList
        }
    }
}

export function loadGameListError(error: errorMessage): ErrorAction {
    return {
        type: LOAD_GAME_LIST_ERROR,
        payload:{
            error
        }
    }
}

export interface AddGameAction extends Action {
    payload :{
        game: vmGame;
    }
}

export interface AddGameSuccessAction extends Action {
    payload :{
        game:vmGame;
    }
}

export interface AddGameErrorAction extends Action {
    payload :{
        error:string;
    }
}

export function addGame(game: vmGame): AddGameAction {
    return {
        type: ADD_GAME,
        payload:{
            game
        }
    }
}

export function addGameSuccess(game: vmGame): AddGameSuccessAction {
    return {
        type: ADD_GAME_SUCCESS,
        payload:{
            game
        }
    }
}

export function addGameError(error: errorMessage): ErrorAction {
    return {
        type: ADD_GAME_ERROR,
        payload:{
            error
        }
    }
}


export interface GetGameAction extends Action {
    payload :{
        id: string,
        title: string,
    }
}

export interface GetGameSuccessAction extends Action {
    payload :{
        game:vmGame;
    }
}

export interface GetGameErrorAction extends Action {
    payload :{
        error:string;
    }
}

export function GetGame(id: string, title: string): GetGameAction {
    return {
        type: GET_GAME,
        payload:{
            id,
            title
        }
    }
}

export function GetGameSuccess(game: vmGame): GetGameSuccessAction {
    return {
        type: GET_GAME_SUCCESS,
        payload:{
            game
        }
    }
}

export function GetGameError(error: errorMessage): ErrorAction {
    return {
        type: GET_GAME_ERROR,
        payload:{
            error
        }
    }
}

export function displaySnackbarSuccess(): Action {
    return {
        type: 'DISPLAY_SNACKBAR_ACTION'
    }
}
