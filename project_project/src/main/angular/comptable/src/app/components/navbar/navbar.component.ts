import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../../services/notification.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  notificationsMessage: Notification[] ; 
  notifications: Notification[] ; 
  constructor(private router:Router,private notificationService: NotificationService) { 
    // setInterval(() => {
    //   this.notificationService.getNotification(1,'document').subscribe((result: any[]) => {
    //     this.notifications = result;
    //   }, error => console.error(error));
    //   this.notificationService.getNotification(1,'message').subscribe((result: any[]) => {
    //     this.notificationsMessage = result;
    //   }, error => console.error(error));
    // }, 1000);

    
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
