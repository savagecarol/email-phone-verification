import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BgIconComponent } from './components/bg-icon/bg-icon.component';
import { FormContainerComponent} from './components/form-container/form-container.component';

@NgModule({
  declarations: [
    AppComponent,
    BgIconComponent,
    FormContainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
