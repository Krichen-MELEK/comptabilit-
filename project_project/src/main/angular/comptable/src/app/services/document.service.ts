import { Document } from './../models/document.model';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../../node_modules/@angular/common/http';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class DocumentService {

  constructor(private http: HttpClient) { }

  addDocument(document) {
    return this.http.post<Document>('/document/add', document);
  }

  getDocument(id: string) {
    return this.http.get<Document>('/document/' + id);
  }

  getAllDocuments(){
    return this.http.get("/document/getAll");
  }
}
