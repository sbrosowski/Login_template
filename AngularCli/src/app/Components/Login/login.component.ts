import {Component, OnInit} from '@angular/core';
import {LoginImpl} from '../../DTOs/implementation/LoginImpl';
import {LoginService} from '../../_service/Login/login.service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username = '';
  private password = '';
  private loginService: LoginService;
  title = 'AngularCli';

  constructor(loginService: LoginService) {

  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef

  login(): void {

    let login;
    let loginResult;
    login = new LoginImpl();
    login.password = this.password;
    login.user = this.username;
    loginResult = this.loginService.login(login);

    console.log('Hello ' + this.username);
    console.log('Password ' + this.password);
  }

}
