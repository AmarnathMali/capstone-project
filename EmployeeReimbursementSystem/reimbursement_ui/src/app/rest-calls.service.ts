import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from './user';
import {Reimbursement} from './reimbursement';

@Injectable({
  providedIn: 'root'
})
export class RestCallsService {

 constructor(private httpVar:HttpClient) { }

getHeadersInfo():any{
return {
headers: new HttpHeaders({
'Content-Type': 'application/json',
'Accept':'*/*'
})
};
}

checkUser(userObj:User):Observable<any>{
var validateLoginRestApi = "http://localhost:8888/user/login";
return this.httpVar.post(validateLoginRestApi, userObj, this.getHeadersInfo());

}

applyReimbursement(reimbursementObj:Reimbursement):Observable<any>{
var applyForNewReimbursementRestApi = "http://localhost:8888/reimbursement/new";
return this.httpVar.post(applyForNewReimbursementRestApi,reimbursementObj,{responseType:'text'});
}

getAllReimbursements(userId:number):Observable<any>{
  console.log(userId);
  var getAllReimbursementsRestApi = "http://localhost:8888/reimbursement/all/"+userId;
  return this.httpVar.get(getAllReimbursementsRestApi);
} 

getAllReimbursementsForMgr():Observable<any>{
   var restApi = "http://localhost:8888/reimbursement/all/";
    return this.httpVar.get(restApi,this.getHeadersInfo());

}
resolveReimbursements(rObj:Reimbursement):Observable<any> {
      var restApi = "http://localhost:8888/reimbursement/resolve";
      return this.httpVar.put(restApi, rObj, this.getHeadersInfo());
  }

}
