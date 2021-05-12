import {IAuthenticationDetails} from './Interfaces/IAuthenticationDetails';


export class AuthenticationDetails implements IAuthenticationDetails {
  password: string;
  username: string;
}
