import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import {RestCallsService} from '../rest-calls.service';
import {UserSrvService} from '../user-srv.service';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {

  constructor(private restSrv:RestCallsService,private userSrv:UserSrvService) { }

  ngOnInit(): void {
       this.userObj = this.userSrv.getLoggedInUser();  
       }

  


  userObj:User = new User();
  

}
