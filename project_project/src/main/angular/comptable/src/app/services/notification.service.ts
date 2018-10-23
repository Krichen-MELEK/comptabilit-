import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { ClientService } from './client.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient,public clientService: ClientService) { }

  getNotification(id:number,type: String){
    return this.http.get('/api/admin/notification/'+id+'/'+type) ; 
  }
  vuNotification(id: number){
    return this.http.get('api/admin/notification/vu/'+id) ; 
  }
  deleteNotification(id: number){
    return this.http.get('api/admin/notification/delete/'+id) ; 
  }
}
