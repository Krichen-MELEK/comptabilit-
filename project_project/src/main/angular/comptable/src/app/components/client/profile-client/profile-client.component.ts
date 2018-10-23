import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../models/client.model';

@Component({
  selector: 'app-profile-client',
  templateUrl: './profile-client.component.html',
  styleUrls: ['./profile-client.component.css']
})
export class ProfileClientComponent implements OnInit {
 public id: number ; 
 public client: Client ; 
 // ijbed lem local storage !!
  constructor(private clientService: ClientService) { }

  ngOnInit() {
  }

}
