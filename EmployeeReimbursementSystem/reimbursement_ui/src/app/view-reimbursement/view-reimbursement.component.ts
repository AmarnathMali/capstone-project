import { Component, OnInit,Input,Output } from '@angular/core';
import {Reimbursement} from '../reimbursement';
import {RestCallsService} from '../rest-calls.service';
import {UserSrvService} from '../user-srv.service';
import {User} from '../user'

@Component({
  selector: 'app-view-reimbursement',
  templateUrl: './view-reimbursement.component.html',
  styleUrls: ['./view-reimbursement.component.css']
})
export class ViewReimbursementComponent implements OnInit {
   
constructor(private restSrv:RestCallsService, private userSrv:UserSrvService) { }

  ngOnInit(): void {
        this.loggedInUser = this.userSrv.getLoggedInUser();
        this.restSrv.getAllReimbursements(this.loggedInUser.userId).subscribe(data => {
               this.allReimbursements =  data.info;
               console.log(this.allReimbursements);
               this.allReimbursementsBackUp = data.info;
        })
  }

  loggedInUser:User = new User(); 
  allReimbursements: Reimbursement[] = [];
  allReimbursementsBackUp:Reimbursement[] = [];

  statusSelected:string = "";

  filterTable(){
      if(this.statusSelected == 'ALL'){
          this.allReimbursements = this.allReimbursementsBackUp;
      }else{
        this.allReimbursements = [];
        for(var i=0; i<this.allReimbursementsBackUp.length; i++){
                if(this.allReimbursementsBackUp[i].status == this.statusSelected){
                     this.allReimbursements.push(this.allReimbursementsBackUp[i]);
                }
        }
      }
  }

}

