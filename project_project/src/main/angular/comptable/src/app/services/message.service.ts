import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Message } from '../models/message.model';
import { ClientService } from './client.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MessageService {


  constructor(private http: HttpClient,public clientService: ClientService) { }

  addMessage(message: Message){
    return this.http.post<Message>('/api/admin/message/create/1/2', message);
  }

  getMessageByClient(id:number){
    return this.http.get('/api/admin/message/reception/view/all/'+id) ; 
  }

  getMessageById(id:number){
    return this.http.get<Message>('/api/admin/message/view/'+id);
  }

}
