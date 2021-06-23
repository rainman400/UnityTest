import { vmGame, vmGameList } from "src/app/conversion/model";
import { State } from "..";

export const selectCurrentGameList = () => (state: State): vmGameList => ((state.games)? state.games.currentGameList : null);
export const selectCurrentGame = () => (state: State): vmGame => ((state.games)? state.games.currentGame : null);
