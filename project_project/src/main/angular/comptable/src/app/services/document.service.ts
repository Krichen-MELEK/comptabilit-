import { Document } from './../models/document.model';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from '../../../node_modules/rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
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
    const req = new HttpRequest('POST', 'client/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    }
    );
    console.log(formdata);
    return this.http.request(req);
  }
  getDocument(id: string) {
    return this.http.get<Document>('/document/' + id);
  }

  getAllDocuments(){
    return this.http.get("/document/getAll");
  }
}
