import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';
import {LocalStorageService} from '../_service/LocalStorage/localStorage.service';
import {LoggedInUser} from '../ServiceObjects/LoggedInUser';

@Injectable({
  providedIn: 'root'
})

export class AuthGuard implements CanActivate {

  constructor(private localStorageService: LocalStorageService) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let loggedInUser: LoggedInUser;
    loggedInUser = JSON.parse(this.localStorageService.getUserSettings());
    // TODO richtige authentifizierung im Backend muss noch gemacht werden
    return loggedInUser.jwtToken !== undefined && loggedInUser.user !== undefined;
  }

}
