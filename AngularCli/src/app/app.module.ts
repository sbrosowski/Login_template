import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AppComponent} from './app.component';
import {HomeComponent} from './Components/Home/home.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSliderModule} from '@angular/material/slider';
import {FormsModule} from '@angular/forms';
import {LoginComponent} from './Components/Login/login.component';
import {UserService} from './_service/Login/user.service';
import {HttpClientModule} from '@angular/common/http';
import {AuthGuard} from './_guard/auth.guard';
import {RegistrationComponent} from './Components/registration/registration.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent
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
        path: 'Register',
        component: RegistrationComponent
      },
      {
        path: '',
        redirectTo: '/Login',
        pathMatch: 'full'
      }

    ])
  ],
  providers: [UserService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
