import {environment} from './../../environments/environment';

export abstract class Service {

  getUrl(): string {
    return environment.apiUrl;
  }
}
