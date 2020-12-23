import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AppComponent} from './app.component';
import {HomeComponent} from './Components/Home/home.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSliderModule} from '@angular/material/slider';
import {FormsModule} from '@angular/forms';
import {LoginComponent} from './Components/Login/login.component';
import {LoginService} from './_service/Login/login.service';
import {HttpClientModule} from '@angular/common/http';
import {AuthGuard} from './_guard/auth.guard';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSliderModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: 'Home',
        component: HomeComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'Login',
        component: LoginComponent
      },
      {
        path: '',
        redirectTo: '/Login',
        pathMatch: 'full'
      }

    ])
  ],
  providers: [LoginService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
