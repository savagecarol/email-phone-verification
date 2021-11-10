import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-form-container',
  templateUrl: './form-container.component.html',
  styleUrls: ['./form-container.component.css']
})
export class FormContainerComponent implements OnInit {

  public emailField: boolean = false;
  public otpField: boolean = true;
  public x:number = 0;

  constructor(private toastr: ToastrService) {}
  ngOnInit(): void {
  }

  validate(email : string) 
  {
  const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(String(email).toLowerCase());
  }

  async otpSendbyEmail(email : string)
  {
    if(this.validate(email) == true)
    {
    this.emailField = true;
    var boo = JSON.stringify({"email" : email});
    const response = await fetch('https://email-verification-spring.herokuapp.com/email', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body :  boo
    });
        if (response.ok) 
        {
            this.toastr.success(email , 'email sent');
            this.emailField = true;
            this.otpField= false;
        }
        else
        {
           this.toastr.success(email , 'network error occur');
           this.emailField = false;
        }
    }
    else
    {
      this.toastr.error(email, 'email is wrong please correct email');
      this.emailField = false;
    }
}

  async validateEmail(email  : string  , otp : string)
  {
 
    var boo = JSON.stringify({"email" : email  , "otp" : otp });
    const response = await fetch('https://email-verification-spring.herokuapp.com/otp-validate', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body :  boo
    });
      
      if(response.ok)
        {
          this.toastr.success(email , 'email verified');  
          this.emailField = false;
          this.otpField= true;  
          setInterval(function(){ location.reload(); }, 3000);
        }      
        else
          {
             this.x = this.x + 1;
             var y = 3 - this.x;
             this.toastr.error(email, 'you have '+ y.toString() + ' attempts');
             if(this.x==3)
             {
               location.reload();
             }
          }
   }
}
