import { Component, OnInit } from '@angular/core';
import { MessageService } from '../../../services/message.service';
import { Message } from '../../../models/message.model';

@Component({
  selector: 'app-email-read',
  templateUrl: './email-read.component.html',
  styleUrls: ['./email-read.component.css']
})
export class EmailReadComponent implements OnInit {

  constructor(public messageService: MessageService) { }
  
  message: Message ; 
  nom: string ; 
  ngOnInit() {
      this.messageService.getMessageById(1).subscribe((result: any) => {
      this.message = result;
      console.log(this.message) ; 
    }, error => console.error(error));
  }

}
