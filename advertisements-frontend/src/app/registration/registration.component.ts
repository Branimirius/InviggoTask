import { Component, Input, OnInit } from '@angular/core';
import { User } from '../models/user';
import { RegistrationService } from '../services/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  @Input() public newUser: User;
  public passwordConfirm : string;
  constructor( private rs: RegistrationService) { 
    this.newUser = new User();
    this.passwordConfirm = "";
  }

  ngOnInit(): void {
  }

  validate() : boolean{
    if (
      this.newUser.username == "" || this.newUser.password == "" ||
      this.newUser.phone == "" || this.newUser.password != this.passwordConfirm 
    )
      return false;
    else 
      return true;
  }

  public sendRegistration(): void{
      console.log(this.newUser);
      this.newUser.dateJoined = new Date(Date.now());
      if(this.validate()){
        this.rs.RegisterUser(this.newUser).subscribe();
        alert("Uspesno ste se registrovali.");
      }
      else{
        alert("Niste ispravno uneli sve potrebne podatke !");
      }
    
  }

}
