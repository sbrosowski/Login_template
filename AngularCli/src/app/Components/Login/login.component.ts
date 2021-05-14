import {Component} from '@angular/core';
import {UserService} from '../../_service/Login/user.service';
import {Router} from '@angular/router';
import {IAuthenticationDetails} from '../../ServiceObjects/Interfaces/IAuthenticationDetails';
import {AuthenticationDetails} from 'src/app/ServiceObjects/AuthenticationDetails';
import {LoggedInUser} from '../../ServiceObjects/LoggedInUser';

@Component({
  selector: 'app-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  title = 'AngularCli';

  constructor(private serviceToLogin: UserService,
              private  router: Router) {

  }

  login(event): void {
    event.preventDefault();

    const target = event.target;
    const login = this.createLogin(target);
    const loggedInUser = new LoggedInUser();

    this.serviceToLogin.login(login).subscribe(data => {

      const jwtToken = data.jwtToken;

      if (jwtToken !== undefined) {
        loggedInUser.user = login.username;
        loggedInUser.jwtToken = jwtToken;
        this.router.navigate(['/home']);
        this.serviceToLogin.isAuthenticated = true;

      } else {
        this.serviceToLogin.isAuthenticated = false;
      }
    });
  }

  private createLogin(target): IAuthenticationDetails {
    const authenticationDetails = new AuthenticationDetails();
    authenticationDetails.password = target.querySelector('#password').value;
    authenticationDetails.username = target.querySelector('#username').value;
    return authenticationDetails;
  }

  redirectToRegistration(): void {
    this.router.navigate(['/Register']);
  }
}
