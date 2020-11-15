import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {MainMenuSelectionComponent} from './MainMenu/main-menu-selection/main-menu-selection.component';

@NgModule({
  declarations: [
    AppComponent,
    MainMenuSelectionComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
