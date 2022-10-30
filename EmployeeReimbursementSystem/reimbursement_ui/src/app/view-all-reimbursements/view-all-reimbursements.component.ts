import { Component, OnInit } from '@angular/core';
import {RestCallsService} from '../rest-calls.service';
import { Reimbursement} from '../reimbursement';

@Component({
  selector: 'app-view-all-reimbursements',
  templateUrl: './view-all-reimbursements.component.html',
  styleUrls: ['./view-all-reimbursements.component.css']
})
export class ViewAllReimbursementsComponent implements OnInit {

  constructor(private restSrv:RestCallsService) { }

  ngOnInit(): void {
      this.restSrv.getAllReimbursementsForMgr().subscribe(data => {
      this.allReimbursements =  data.info;
      for(var r of this.allReimbursements){
            this.allUserNames.push(r.userName);
      }
      this.allReimbursementsBackUp = data.info;
     this.allUserNames = [...new Set(this.allUserNames)];
    });
  
  }
 allReimbursements:Reimbursement[] = [];
  allReimbursementsBackUp:Reimbursement[] = [];
  allUserNames:string[] = [];
  selectedUserName:string = '';
  statusSelected:string = '';

  filterTable(){
    if(this.statusSelected == 'ALL' && this.selectedUserName ==''){
      this.allReimbursements = this.allReimbursementsBackUp;             
      return;
    }
    if(this.selectedUserName != ''){
      this.allReimbursements = [];
      for(var r of this.allReimbursementsBackUp) {
        if(r.userName == this.selectedUserName) {
             this.allReimbursements.push(r);
        }
      }
    }else{
        this.allReimbursements = this.allReimbursementsBackUp;
    }
  }

  filterTableByStatus(){
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




