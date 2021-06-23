import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddPageComponent } from './components/add-page/add-page.component';
import { StoreModule } from '@ngrx/store';
import { reducers, metaReducers } from './store';
import { addPageContainer } from './containers/add-page-container.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { EffectsModule, USER_PROVIDED_EFFECTS } from '@ngrx/effects';
import { GamesEffects } from './store/gameStore/game.effects';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    AddPageComponent,
    addPageContainer
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    StoreModule.forRoot(reducers, {
      metaReducers
    }),
    EffectsModule.forRoot([GamesEffects]),
    HttpClientModule,
    MatSnackBarModule,
    BrowserModule,
    BrowserAnimationsModule,
  ],
  providers: [
    HttpClient,
    // GamesEffects,
    // {
    //   provide: USER_PROVIDED_EFFECTS,
    //   multi: true,
    //   useValue: [GamesEffects],
    // },
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
