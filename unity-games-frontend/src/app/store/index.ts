import {
  ActionReducer,
  ActionReducerMap,
  createFeatureSelector,
  createSelector,
  MetaReducer
} from '@ngrx/store';
import { environment } from '../../environments/environment';
import { gamesReducer } from './gameStore/game.reducer';
import { GameState } from './gameStore/game.state';

export interface State {
  games?: GameState
}

export const reducers: ActionReducerMap<State> = {
  games: gamesReducer
};


export const metaReducers: MetaReducer<State>[] = !environment.production ? [] : [];

export const effects: any[] =[

]