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

    var boo = JSON.stringify({"email" : email});
    const response = await fetch('https://email-verification-spring.herokuapp.com/email', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body :  boo
    });
        if (response.ok) alert(email + " email send");
        else  alert("oops! email cannot be send");
  }

  async validateEmail(email  : string  , otp : string)
  {
    var boo = JSON.stringify({"email" : email  , "otp" : otp });
    const response = await fetch('https://email-verification-spring.herokuapp.com/otp-validate', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body :  boo
    });
        if (response.ok)
        {
          console.log(response.json());
          alert(email + " email verified");
        }      
        else alert("lol");
  }
}
