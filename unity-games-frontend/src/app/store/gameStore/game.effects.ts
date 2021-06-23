import { Injectable } from "@angular/core";
import { Action, Store} from "@ngrx/store";
import { State } from "..";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, of} from "rxjs";
import {catchError, concatMap, debounceTime, map, mergeMap, switchMap, withLatestFrom} from "rxjs/operators";
import { AddGameAction, addGameError, AddGameErrorAction, addGameSuccess, ADD_GAME, ADD_GAME_ERROR, displaySnackbarSuccess, ErrorAction, GetGameAction, GET_GAME, GET_GAME_ERROR, loadGameList, LoadGameListAction, loadGameListError, loadGameListSuccess, LOAD_GAME_LIST, LOAD_GAME_LIST_ERROR } from "./game.actions";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import { convertToGame, convertToGameList } from "src/app/conversion/conversion-from-rest";
import { convertToGameRsrc } from "src/app/conversion/conversion-to-rest";
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';
import { errorMessage } from "src/app/conversion/model";

export const SNACKBAR_ERROR_CONFIG : MatSnackBarConfig = {panelClass: 'snackbar-error', duration: 3000};

@Injectable()
export class GamesEffects {
    constructor(
        private actions: Actions,
        private store: Store<State>,
        private httpClient: HttpClient,
        private snackBar: MatSnackBar
    ){}

    loadGames: Observable<Action> = createEffect(() => this.actions
        .pipe(
            ofType(LOAD_GAME_LIST),
            withLatestFrom(this.store),
            switchMap (([action,store]) => {
                let typedAction = <LoadGameListAction>action;
                let url = "localhost:8080/games"
                return this.httpClient.get(
                    url
                )
                .pipe(
                    map((response: any) => loadGameListSuccess(convertToGameList(response))),
                    catchError(error => of(loadGameListError(error)))
                )
            })

        ));

    getGame: Observable<Action> = createEffect(() => this.actions
        .pipe(
            ofType(GET_GAME),
            withLatestFrom(this.store),
            switchMap (([action,store]) => {
                let typedAction = <GetGameAction>action;
                let url = new URL("localhost:8080/game");
                if(typedAction.payload.id) {
                    url.searchParams.append('gameId',typedAction.payload.id)
                }
                if(typedAction.payload.title) {
                    url.searchParams.append('title',typedAction.payload.title);
                }
                
                return this.httpClient.get(
                    url.href
                )
                .pipe(
                    map((response: any) => loadGameListSuccess(convertToGameList(response))),
                    catchError(error => of(loadGameListError(error)))
                )
            })

        ));

    
    addGame: Observable<Action> = createEffect(() => this.actions
    .pipe(
        ofType(ADD_GAME),
        withLatestFrom(this.store),
        switchMap (([action,store]) => {
            let typedAction = <AddGameAction>action;
            let url = "http://localhost:8080/game"
            let body = convertToGameRsrc(typedAction.payload.game);
            let corsHeaders = new HttpHeaders({
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*'
              });

            return this.httpClient.post(
                url,
                JSON.stringify(body),
                {observe: 'response',headers: corsHeaders}
            )
            .pipe(
                map((response: any) => addGameSuccess(convertToGame(response.body))),
                catchError(error => of(addGameError(error)))
            )
        })

    ));

    error: Observable<Action> = createEffect(() => this.actions
    .pipe(
        ofType(ADD_GAME_ERROR,LOAD_GAME_LIST_ERROR,GET_GAME_ERROR),
        switchMap(
            (action: ErrorAction) => {
              setTimeout(()=> {
                this.snackBar.open( "ERROR!!: "+action.payload.error.message, null, SNACKBAR_ERROR_CONFIG);
              })
              return of(displaySnackbarSuccess());
            }
          )
    ));


    
}


