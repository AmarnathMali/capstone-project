import { Component, OnInit } from '@angular/core';
import {RestCallsService} from '../rest-calls.service';
import {Reimbursement} from '../reimbursement';

@Component({
  selector: 'app-resolve-reimbursements',
  templateUrl: './resolve-reimbursements.component.html',
  styleUrls: ['./resolve-reimbursements.component.css']
})
export class ResolveReimbursementsComponent implements OnInit {

 constructor(private restSrv:RestCallsService) { }

  ngOnInit(): void {
    this.restSrv.getAllReimbursementsForMgr().subscribe(data => {
      this.allReimbursements =  data.info;
      console.log(this.allReimbursements);
    
    });
  }

  resolveOptions:string[] = ["PENDING", "ACCEPT", "DENY"];

  resolveStatus:string = "";
  rId:number = 0;

  allReimbursements:Reimbursement[] = [];
  selectedReimbursement:Reimbursement = new Reimbursement();

  msg:string = "";

  resolveReimbursement(){  
    this.restSrv.resolveReimbursements(this.selectedReimbursement).subscribe(data => {
      this.msg =  data.info;
      this.selectedReimbursement = new Reimbursement();

    });
  }

}
