import { Client } from './../models/client.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../node_modules/@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ClientService {

  constructor(private http: HttpClient) { }

  addClient(client) {
    return this.http.post<Client>('/client/add', client);
  }

  getClient(id: string) {
    return this.http.get<Client>('/client/' + id);
  }

  getAllClients(){
    return this.http.get("/client/getAll");
  }
}
