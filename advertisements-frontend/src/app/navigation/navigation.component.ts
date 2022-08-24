import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { User } from '../models/user';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  

  @ViewChild('secondDialog', { static: true })
  secondDialog!: TemplateRef<any>;
  @ViewChild('firstDialog', { static: true })
  firstDialog!: TemplateRef<any>;
  public currentUser: User;
  constructor(private authenticationService: AuthenticationService,
    private dialog: MatDialog) {
      this.currentUser = new User;
      this.currentUser = authenticationService.currentUserValue;
      

  }

  ngOnInit(): void {
  }

  logOut(){
    this.authenticationService.logout();
  }
  openDialogWithoutRef() {
    
      this.dialog.open(this.secondDialog);
      
    
    
  }

}
