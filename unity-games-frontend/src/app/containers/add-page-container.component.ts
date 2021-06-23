import { Component, Directive, Injectable } from "@angular/core";
import { select, Store } from "@ngrx/store";
import { Observable } from "rxjs";
import { vmGame, vmGameList } from "../conversion/model";
import { State } from "../store";
import { selectCurrentGame, selectCurrentGameList } from "../store/gameStore/game.selector";


@Component({
    selector: 'add-page-container',
    template: `
        <app-add-page
            [gamesList]="gamesList$ | async"
            [game]="game$ | async"
        ></app-add-page>`,
})

@Directive()
@Injectable()
export class addPageContainer {
    constructor(
        private store: Store<State>
    ){}

    gameList$: Observable<vmGameList> = this.store.pipe(select(selectCurrentGameList()));
    game$: Observable<vmGame> = this.store.pipe(select(selectCurrentGame()));
}