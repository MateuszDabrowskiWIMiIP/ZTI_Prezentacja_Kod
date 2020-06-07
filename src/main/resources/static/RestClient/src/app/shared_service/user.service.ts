import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap} from 'rxjs/operators';

import {User} from '../user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl:string = 'http://localhost:8080/api';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  private options = new HttpRequest('GET', this.baseUrl, {headers: this.headers});
  private user: User;


  private httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };




  constructor(private _http: HttpClient) { }

  getUsers() {
    return this._http.get<User[]>(this.baseUrl + '/users', this.httpOptions);
  }

  getUser(id: number) {

    return this._http.get<User>(this.baseUrl + '/user/' + id, this.httpOptions);
  }

  deleteUser(id: number) {

    return this._http.delete(this.baseUrl + '/user/' + id, this.httpOptions);
  }

  createUser(user: User) {

    return this._http.post(this.baseUrl + '/user', JSON.stringify(user), this.httpOptions);
  }

  updateUser(user: User) {

    return this._http.put(this.baseUrl + '/user', JSON.stringify(user), this.httpOptions);
  }

  errorHandler(error: Response) {

    return Observable.throw(error || 'SERVER ERROR');

  }

  setter(user) {
    this.user = user;

  }

  gettter() {
   return this.user;
  }
}
