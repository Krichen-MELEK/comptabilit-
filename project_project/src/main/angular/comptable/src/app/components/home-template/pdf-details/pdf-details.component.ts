import { Component, OnInit, Output } from '@angular/core';
import { DocumentService } from '../../../services/document.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pdf-details',
  templateUrl: './pdf-details.component.html',
  styleUrls: ['./pdf-details.component.css']
})
export class PdfDetailsComponent implements OnInit {

  id: number ; 
  @Output()
  document: Document ; 
  path: string ; 

  constructor(private documentService: DocumentService,private route: ActivatedRoute) { 
    this.route.params.subscribe( params => {
      this.id = params.id ;
    });
    this.documentService.getDocument(this.id).subscribe((result: any) => {
      this.document = result;
      console.log(this.document) ;  
      this.path = '/assets/ProfilePictureStore/';  
    }, error => console.error(error));
  }
  
   
  ngOnInit() {}
  


}
