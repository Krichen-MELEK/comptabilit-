import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../../services/notification.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  notifications: Notification[] ; 
  constructor(private router:Router,private notificationService: NotificationService) { 
    this.notificationService.getNotificationMessageByidPersonne(1).subscribe((result: any[]) => {
      this.notifications = result;
      console.log(this.notifications) ;
    }, error => console.error(error));
  }

  ngOnInit() {
   
  }
  redirect(idMessage:number,idNotification){
    this.notificationService.deleteNotification(idNotification).subscribe((result: any) => {
   console.log('notification vu') ; 
    }, error => console.error(error));
    this.router.navigateByUrl('client/email-read/'+idMessage) ; 
  }
}
