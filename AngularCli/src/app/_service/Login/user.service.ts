import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ILoginResult} from '../../ServiceObjects/Interfaces/ILoginResult';
import {ILogin} from '../../ServiceObjects/Interfaces/ILogin';
import {Observable} from 'rxjs';
import {Service} from '../AbstractService';
import {IRegistration} from '../../ServiceObjects/Interfaces/IRegistration';


@Injectable()
export class UserService extends Service {

  // tslint:disable-next-line:variable-name
  private _isAuthenticated = false;

  constructor(private http: HttpClient) {
    super();
  }

  login(login: ILogin): Observable<ILoginResult> {

    return this.http.post<ILoginResult>(this.getUrl() + '/authenticate', {
      login
    });
  }

  registration(registration: IRegistration): Observable<ILoginResult> {
    return this.http.post<ILoginResult>(this.getUrl() + '/register', {
      registration
    });
  }


  get isAuthenticated(): boolean {
    return this._isAuthenticated;
  }

  set isAuthenticated(value: boolean) {
    this._isAuthenticated = value;
  }
}
