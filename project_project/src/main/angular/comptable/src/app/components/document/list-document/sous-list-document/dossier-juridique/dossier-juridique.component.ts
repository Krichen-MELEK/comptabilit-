import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '../../../../../../../node_modules/@angular/router';
import { DocumentService } from '../../../../../services/document.service';

@Component({
  selector: 'app-dossier-juridique',
  templateUrl: './dossier-juridique.component.html',
  styleUrls: ['./dossier-juridique.component.css']
})
export class DossierJuridiqueComponent implements OnInit {

  private annee: number ; 
  documents: Document[] ; 
  constructor(private documentService: DocumentService,private route: ActivatedRoute) {
    this.route.params.subscribe( params => {
      this.annee = params.annee ;
      this.documentService.getDossierJuridique(this.annee,1).subscribe((result: any) => {
        this.documents = result;
        console.log(this.documents) ; 
      }, error => console.error(error));
    });
   }

  ngOnInit() {
  }

}
