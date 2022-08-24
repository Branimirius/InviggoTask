import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Advertisement } from '../models/advertisement';
import { User } from '../models/user';

@Injectable({
    providedIn: 'root'
  })
export class AdvertisementService {  
    constructor (private http: HttpClient) {
      
    }

    public GetAdvertisements() : Observable<Advertisement> {
        return this.http.get<any>("http://localhost:8081/api/ads");
    }

    


    
}