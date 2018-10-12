import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '../../../../../node_modules/@angular/router';
import { DocumentService } from '../../../services/document.service';
import { SafeHtml } from '../../../../../node_modules/@angular/platform-browser';
import { DomSanitizer, SafeUrl, SafeResourceUrl } from '@angular/platform-browser';


@Component({
  selector: 'app-view-document',
  templateUrl: './view-document.component.html',
  styleUrls: ['./view-document.component.css']
})
export class ViewDocumentComponent implements OnInit {

  id: number ; 
  document: Document ; 
  path: string ; 

  constructor(private documentService: DocumentService,private route: ActivatedRoute) { 
    this.route.params.subscribe( params => {
      this.id = params.id ;
    });
    this.documentService.getDocument(this.id).subscribe((result: any) => {
      this.document = result;
      console.log(this.document) ;  
      this.path = '../../../assets/ProfilePictureStore/';  
    }, error => console.error(error));
  }
   
  ngOnInit() {}


    

}
