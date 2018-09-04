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
    return this.http.post<Client>('/client/add', client);
  }

  getClient(id: number) {
    return this.http.get<Client>('/admin/client/' + id);
  }

  getClientValidation(valide: Boolean){
    return this.http.get('/admin/client/validation/' + valide) ; 
  }
  getAllClients(){
    return this.http.get("/client/getAll");
  }
  deleteClient(id:number){
    return this.http.delete("/admin/client/delete/"+id) ; 
  }
  approuverClient(id:number){
    return this.http.get("/admin/client/approuver/"+id)
  }
}
