import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';

@Injectable({
    providedIn: 'root'
  })
export class RegistrationService {  
    constructor (private http: HttpClient) {
      
    }

    public RegisterUser(user: User){
        const body = {
            username : user.username,
            password: user.password,
            phone : user.phone,
            dateJoined: user.dateJoined,
            
          };
          let headers = new HttpHeaders({
            'Content-Type': 'application/json' });
          let options = { headers: headers };
        return this.http.post<any>("http://localhost:8081/api/users", body, options);
    }

    


    
}