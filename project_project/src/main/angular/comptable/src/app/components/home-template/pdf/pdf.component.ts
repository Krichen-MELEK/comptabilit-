import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../../services/document.service';

@Component({
  selector: 'app-pdf',
  templateUrl: './pdf.component.html',
  styleUrls: ['./pdf.component.css']
})
export class PdfComponent implements OnInit {

  documents: Document[] ; 
  constructor(private documentService: DocumentService) {
    this.documentService.getDocumentNews("actualite").subscribe((result: any) => {
      this.documents = result;
      console.log(this.documents) ; 
    }, error => console.error(error));
   }

  ngOnInit() {
    
  }

}
