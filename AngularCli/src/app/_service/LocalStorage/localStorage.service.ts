import {Injectable} from '@angular/core';

@Injectable()
export class LocalStorageService {
  private storageName = 'Settings';

  setSettings(data: any): void {
    localStorage.setItem(this.storageName, JSON.stringify(data));
  }

  getUserSettings(): string {
    const data = localStorage.getItem(this.storageName);
    return JSON.parse(data);
  }

  clearUserSettings(): void {
    localStorage.removeItem(this.storageName);
  }

  cleanAll(): void {
    localStorage.clear();
  }

  constructor() {
  }
}
