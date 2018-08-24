import { ClientService } from './../../../services/client.service';

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '../../../../../node_modules/@angular/forms';


@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  clientForm: FormGroup;

  constructor(public clientService: ClientService) { 
    
    this.clientForm = new FormGroup({
    nom: new FormControl(),
    prenom: new FormControl(),
    email: new FormControl(),
    motDePasse: new FormControl(),
    telephone:new FormControl(),
    adresse: new FormControl(),
    nomSociete: new FormControl(),
    adresseSociete: new FormControl(),
    telSociete: new FormControl(),
    matricule: new FormControl(),
    numRegistreCommerce: new FormControl(),
    emailSociete: new FormControl(),
    secteurActivite: new FormControl(),
  }) }

  ngOnInit() {
  }

  onSubmit({value,valid}){
    console.log(value);
    this.clientService.addClient(value).subscribe(data =>{
      console.log("goo");
    },error=> console.error(error));
  }

}
