import {ILoggedInUser} from './Interfaces/ILoggedInUser';


export class LoggedInUser implements ILoggedInUser {
  user: string;
  jwtToken: string;
}
