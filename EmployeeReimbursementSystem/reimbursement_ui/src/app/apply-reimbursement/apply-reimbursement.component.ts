import { Component, OnInit } from '@angular/core';
import {Reimbursement} from '../reimbursement';
import {RestCallsService} from '../rest-calls.service';
import {UserSrvService}  from '../user-srv.service';

@Component({
  selector: 'app-apply-reimbursement',
  templateUrl: './apply-reimbursement.component.html',
  styleUrls: ['./apply-reimbursement.component.css']
})
export class ApplyReimbursementComponent implements OnInit {

  constructor(private restSrv : RestCallsService,private userSrv:UserSrvService) { }

  ngOnInit(): void {
  }
  reimbursementObj:Reimbursement = new Reimbursement();
  acknowledgeMsg:string = "";

 applyReimbursement(){
    this.reimbursementObj.userId =  this.userSrv.getLoggedInUser().userId;
    this.restSrv.applyReimbursement(this.reimbursementObj).subscribe(data =>{
      this.acknowledgeMsg = data.info;
      this.reimbursementObj.reason="";
      this.reimbursementObj.amount=0;
      
    });
 }

}
