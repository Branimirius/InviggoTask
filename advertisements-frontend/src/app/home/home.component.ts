import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { Advertisement } from '../models/advertisement';
import { User } from '../models/user';
import { AdvertisementService } from '../services/advertisement.service';
import { MatDialogModule, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { UserService } from '../services/user.service';
import { AuthenticationService } from '../services/authentication.service';


@Component({templateUrl: './home.component.html'
})
export class HomeComponent  implements OnInit{

  public ads: Advertisement[];
  public users: User[];
  peekProfile: User; 
  peekAdd: Advertisement;
  currentUser: User;
  dialogUser: number;

  @ViewChild('secondDialog', { static: true })
  secondDialog!: TemplateRef<any>;
  @ViewChild('firstDialog', { static: true })
  firstDialog!: TemplateRef<any>;


  
  constructor(private adService: AdvertisementService,
    private dialog: MatDialog,
    private userService: UserService,
    private authenticationService: AuthenticationService
    ) {
    // for (let i = 1; i <= 100; i++) {
    //   this.collection.push(`item ${i}`);
    // }
    this.currentUser = authenticationService.currentUserValue;
    this.peekProfile = new User();
    this.peekAdd = new Advertisement();
    this.dialogUser = 0;
    this.ads = [];
    this.users = [];
    this.GetAds()
    this.GetUsers();
  }
  ngOnInit(): void {
    
  }

  GetAds(){
    this.adService.GetAdvertisements()
    .subscribe((data: any) => {
      this.ads.length = 0;
      for(const d of (data as any)){
        this.ads.push(d);
      }
    })
  }

  openDialogWithoutRef(userId: number, first: boolean) {
    this.peekProfile = this.getUser(userId);
    if(first){
      this.dialog.open(this.firstDialog);
      this.dialogUser = userId;
    }
    else{
      this.dialog.open(this.secondDialog);
      this.dialogUser = userId;
      console.log(userId);
    }
    
  }

  GetUsers(){
    this.userService.GetAllUsers()
    .subscribe((data: any) => {
      this.users.length = 0;
      for(const d of (data as any)){
          this.users.push(d);
      }
    })
  }

  getUser(id: number): User{
    for(let c of this.users){
      if(c.id == id){
        return c;
      }
    }
    return new User();
  }
  
}
