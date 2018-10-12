import { Document } from './../models/document.model';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from '../../../node_modules/rxjs';
import {ResponseContentType } from '@angular/http';

const httpOptions = {
  headers: new HttpHeaders({ 
    'Content-Type': 'application/json',
    "Access-Control-Allow-Origin": "*",
    "Authorization": "Bearer "
  }), responseType: ResponseContentType.ArrayBuffer 
};

@Injectable()
export class DocumentService {
  
  constructor(private http: HttpClient) { }

  addDocument(file: File, value: any): Observable<HttpEvent<{}>> {

    const formdata: FormData = new FormData();
    /* console.log(file); */
    formdata.append('file', file);
    formdata.append('type', value['type']);
    formdata.append('annee',value['annee']);
    console.log(value['type']);
    const req = new HttpRequest('POST', '/api/client/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    }
    );
    console.log(formdata);
    return this.http.request(req);
  }
  getDocument(id: number) {
    return this.http.get<Document>('/api/client/document/' + id);
  }
  getDossierJuridique(annee:number,id: number){
    return this.http.get<Document>('/api/client/document/dossierJuridique/'+annee+'/'+id) ; 
  }
 getBilanAnnuel(annee:number,id: number){
  return this.http.get<Document>('/api/client/document/bilanAnnuel/'+annee+'/'+id) ;
 }
 getBilanMensuel(annee:number,mois: String,id: number){
  return this.http.get<Document>('/api/client/document/bilanMensuel/'+annee+'/'+mois+'/'+id) ;
 }
}
