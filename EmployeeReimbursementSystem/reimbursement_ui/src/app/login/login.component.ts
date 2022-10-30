import { Component, OnInit } from '@angular/core';
import {RestCallsService} from '../rest-calls.service';
import {User} from '../user';
import {UserSrvService} from '../user-srv.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private restSrv : RestCallsService,private userSrv:UserSrvService, private routerVar:Router) { }

  ngOnInit(): void {
  }

 userObj:User = new User();
 loginErrMsg:string = '';

 validateLogin(){
this.restSrv.checkUser(this.userObj).subscribe(data => {
var user = data.info;
//console.log(user);
alert("recieved response data "+user);
if(user == null){
  this.userObj = new User();
  this.loginErrMsg = "Invalid credentials";
}
else{
  this.userSrv.setLogin(true,user);
  this.routerVar.navigate(['/base']);
}

});
}


}
