import {Component} from '@angular/core';
import {LoginService} from '../../_service/Login/login.service';
import {Login} from '../../ServiceObjects/Login';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  title = 'AngularCli';

  constructor(private loginService: LoginService,
              private  router: Router) {

  }

  login(event): void {
    event.preventDefault();
    console.log(event);
    const target = event.target;
    let login;
    let loginResult;
    login = new Login();

    login.password = target.querySelector('#password').value;
    login.user = target.querySelector('#username').value;

    loginResult = this.loginService.login(login).subscribe(data => {
      console.log(data);
      if (data.successful) {
        this.router.navigate(['/Home']);
        this.loginService.isAuthenticated = true;
        window.alert('valid');
      } else {
        this.loginService.isAuthenticated = false;
        window.alert('invalid');
      }
    });
    console.log(loginResult);

  }

}
