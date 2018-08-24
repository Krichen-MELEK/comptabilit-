import { ClientComponent } from './components/client/client.component';
import { AddClientComponent } from './components/client/add-client/add-client.component';
import { ClientService } from './services/client.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DocumentComponent } from './components/document/document.component';
import { AddDocumentComponent } from './components/document/add-document/add-document.component';
import { DocumentService } from './services/document.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ListClientComponent } from './components/client/list-client/list-client.component';
import { LeftSidebarComponent } from './components/left-sidebar/left-sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    AddClientComponent,
    DocumentComponent,
    AddDocumentComponent,
    NavbarComponent,
    ListClientComponent,
    LeftSidebarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    ClientService,
    DocumentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
