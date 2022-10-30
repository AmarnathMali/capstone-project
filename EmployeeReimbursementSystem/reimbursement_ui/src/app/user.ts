
export class User {
   userId:number;
   userName:string;
   pwd:string;
   fName:string;
   lName:string;
   role:string;
   emailId:string;

   constructor(userId:number=0, userName:string="", pwd:string="",
   					fName:string="", lName:string="", role:string="", emailId:string=""	) {

   		 this.userId = userId;
   		 this.userName = userName;
   		 this.pwd = pwd;
   		 this.fName = fName;
   		 this.lName = lName;
   		 this.role = role;
   		 this.emailId = emailId;
   	}


}
