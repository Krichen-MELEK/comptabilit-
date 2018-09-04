import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Message } from '../models/message.model';
import { ClientService } from './client.service';
import { Client } from '../models/client.model';
import { Observable } from '../../../node_modules/rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MessageService {


  constructor(private http: HttpClient,public clientService: ClientService) { }

  addMessage(message: Message){
    return this.http.post<Message>('/admin/message/create/1/2', message);
  }

  getMessageByClient(id:number){
    console.log("getMessag") ; 
    return this.http.get('/admin/message/reception/view/all/'+id) ; 
  }

}
