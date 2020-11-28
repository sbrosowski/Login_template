import {Injectable} from '@angular/core';
import {LoginResultImpl} from '../../DTOs/implementation/LoginResultImpl';


@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor() {
  }

  login(login: Login): LoginResult {

    let username;
    let password;

    username = login.username;
    password = login.password;
    return new LoginResultImpl();
  }
}
