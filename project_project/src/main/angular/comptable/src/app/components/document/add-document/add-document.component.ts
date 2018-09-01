import { DocumentService } from '../../../services/document.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-add-document',
  templateUrl: './add-document.component.html',
  styleUrls: ['./add-document.component.css']
})
export class AddDocumentComponent implements OnInit {

  progress: { percentage: number } = { percentage: 0 };
  addDocumentForm: FormGroup;

  constructor(public documentService: DocumentService) { 
    this.addDocumentForm = new FormGroup({
      file: new FormControl()
    })
  }

  ngOnInit() {
  }

  onSubmit({value,valid}){
    console.log(value);
    this.documentService.addDocument(value).subscribe(data =>{
      console.log("goo");
    },error=> console.error(error));
  }
}
