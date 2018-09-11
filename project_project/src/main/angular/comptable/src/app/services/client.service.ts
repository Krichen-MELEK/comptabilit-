import { Client } from '../models/client.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ClientService {

  constructor(private http: HttpClient) { }

  addClient(client) {
    return this.http.post<Client>('/api/client/add', client);
  }

  getClient(id: number) {
    return this.http.get<Client>('/api/admin/client/view/' + id);
  }

  getClientValidation(valide: Boolean){
    return this.http.get('/api/admin/client/validation/' + valide) ; 
  }
  getAllClients(){
    return this.http.get("/api/client/getAll");
  }
  deleteClient(id:number){
    return this.http.delete("/api/admin/client/delete/"+id) ; 
  }
  approuverClient(id:number){
    return this.http.get("/api/admin/client/approuver/"+id)
  }
}
