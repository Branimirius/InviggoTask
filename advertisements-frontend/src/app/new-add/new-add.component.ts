import { Component, OnInit } from '@angular/core';
import { AdvertisementService } from '../services/advertisement.service';

@Component({
  selector: 'app-new-add',
  templateUrl: './new-add.component.html',
  styleUrls: ['./new-add.component.css']
})
export class NewAddComponent implements OnInit {

  constructor(private advertisementService: AdvertisementService) { }

  ngOnInit(): void {
  }

  whatever(){
    //this.advertisementService.
  }

}
