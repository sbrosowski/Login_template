import {Component} from '@angular/core';
import {UserService} from '../../_service/Login/user.service';
import {Login} from '../../ServiceObjects/Login';
import {Router} from '@angular/router';
import {ILogin} from '../../ServiceObjects/Interfaces/ILogin';

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

    this.serviceToLogin.login(login).subscribe(data => {

      if (data.successful) {
        this.router.navigate(['/Home']);
        this.serviceToLogin.isAuthenticated = true;

      } else {
        this.serviceToLogin.isAuthenticated = false;
      }
    });

  }

  private createLogin(target): ILogin {
    const login = new Login();
    login.password = target.querySelector('#com.pma.password').value;
    login.username = target.querySelector('#username').value;
    return login;
  }

  redirectToRegistration(): void {
    this.router.navigate(['/Register']);
  }
}
