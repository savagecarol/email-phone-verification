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

    
    // fetch('http://localhost:9099/email')
    // .then(response => response.json())
    // .then(data => console.log(data));

    var boo = JSON.stringify({"email" : email});
    const response = await fetch('http://localhost:9099/email', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body :  boo
    });
        if (response.ok) alert(email + " email send");
        else console.log("lol ho gaya");
  }

  async validateEmail(email  : string  , otp : string)
  {
    var boo = JSON.stringify({"email" : email  , "otp" : otp });
    const response = await fetch('http://localhost:9099/otp-validate', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body :  boo
    });
        if (response.ok)
        {
          console.log(response);
          alert(email + " email verified");
        }      
        else console.log("lol ho gaya");

  }
}
