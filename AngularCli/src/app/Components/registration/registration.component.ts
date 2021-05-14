import {Component, OnInit} from '@angular/core';
import {UserService} from '../../_service/Login/user.service';
import {Router} from '@angular/router';
import {IRegistration} from '../../ServiceObjects/Interfaces/IRegistration';
import {Registration} from '../../ServiceObjects/Registration';
import {LoggedInUser} from '../../ServiceObjects/LoggedInUser';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private serviceToRegister: UserService,
              private  router: Router) {
  }

  ngOnInit(): void {
  }

  register($event: Event): void {
    $event.preventDefault();
    const target = $event.target;

    const registration = this.createRegistrationObject(target);
    this.serviceToRegister.registration(registration).subscribe(data => {
      const loggedInUser = new LoggedInUser();

      const jwtToken = data.jwtToken;

      if (jwtToken !== undefined) {
        loggedInUser.user = registration.username;
        loggedInUser.jwtToken = jwtToken;
        this.router.navigate(['/login']);
      }
    });
  }

  private createRegistrationObject(target): IRegistration {
    const register = new Registration();
    register.firstName = target.querySelector('#firstname').value;
    register.surname = target.querySelector('#surname').value;
    register.username = target.querySelector('#username').value;
    register.email = target.querySelector('#email').value;
    register.password = target.querySelector('#com.pma.password').value;
    register.passwordConfirmation = target.querySelector('#passwordConfirmation').value;
    return register;
  }
}
