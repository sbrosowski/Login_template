import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ILoginResult} from '../../ServiceObjects/Interfaces/ILoginResult';
import {IAuthenticationDetails} from '../../ServiceObjects/Interfaces/IAuthenticationDetails';
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

  login(authenticationDetails: IAuthenticationDetails): Observable<ILoginResult> {

    const httpOptions = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
      })
    };

    const body = JSON.stringify(authenticationDetails);
    return this.http.post<ILoginResult>(this.getUrl() + '/authenticate', body, httpOptions);
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
