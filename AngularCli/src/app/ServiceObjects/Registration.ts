import {IRegistration} from './Interfaces/IRegistration';

export class Registration implements IRegistration {
  email: string;
  firstName: string;
  password: string;
  surname: string;
  username: string;
  passwordConfirmation: string;

}
