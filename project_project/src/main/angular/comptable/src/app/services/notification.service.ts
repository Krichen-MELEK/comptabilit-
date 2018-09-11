import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../../node_modules/@angular/common/http';
import { ClientService } from './client.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient,public clientService: ClientService) { }

  getNotificationMessageByidPersonne(id:number){
    return this.http.get('/api/admin/notification/message/'+id) ; 
  }
  vuNotification(id: number){
    return this.http.get('api/admin/notification/vu/'+id) ; 
  }
  deleteNotification(id: number){
    return this.http.get('api/admin/notification/delete/'+id) ; 
  }
}
