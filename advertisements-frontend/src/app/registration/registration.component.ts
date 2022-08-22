import { Component, Input, OnInit } from '@angular/core';
import { User } from '../models/user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  @Input() public newUser: User;
  public passwordConfirm : string;
  constructor() { 
    this.newUser = new User();
    this.passwordConfirm = "";
  }

  ngOnInit(): void {
  }

}
