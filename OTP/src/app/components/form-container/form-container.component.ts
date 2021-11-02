import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-container',
  templateUrl: './form-container.component.html',
  styleUrls: ['./form-container.component.css']
})
export class FormContainerComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  async otpSendbyEmail(email : string)
  {
    var boo = {"email" : email}

    const response = await fetch('localhost:9090', {
      method: 'POST',
      body: JSON.stringify(boo),
      headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'} });
    
    if (!response.ok) { 
      alert(email + " email send");
    }
    if (response.body !== null) {
      alert(response.body);
    }
    alert(email);
  }
validateEmail(String  : string)
  {
    alert(String);
  }
}
