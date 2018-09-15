import { MessageService } from './services/message.service';
import { ClientComponent } from './components/client/client.component';
import { ClientService } from './services/client.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DocumentComponent } from './components/document/document.component';
import { AddDocumentComponent } from './components/document/add-document/add-document.component';
import { DocumentService } from './services/document.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ListClientComponent } from './components/client/list-client/list-client.component';
import { LeftSidebarComponent } from './components/left-sidebar/left-sidebar.component';
import { TemplateAdminComponent } from './components/admin/template-admin.component';
import { AdminLeftSidebarComponent } from './components/admin/admin-left-sidebar/admin-left-sidebar.component';
import { AdminPageContentComponent } from './components/admin/admin-page-content/admin-page-content.component';
import { EmailComposeComponent } from './components/email/email-compose/email-compose.component';
import { EmailReadComponent } from './components/email/email-read/email-read.component';
import { EmailInboxComponent } from './components/email/email-inbox/email-inbox.component';
import { StatistiqueComponent } from './components/admin/statistique/statistique.component';
import { CollaborateurComponent } from './components/collaborateur/collaborateur.component';
import { ListCollaborateurComponent } from './components/collaborateur/list-collaborateur/list-collaborateur.component';
import { NewCollaborateurComponent } from './components/collaborateur/new-collaborateur/new-collaborateur.component';
import { ProfileCollaborateurComponent } from './components/collaborateur/profile-collaborateur/profile-collaborateur.component';
import { EditCollaborateurComponent } from './components/collaborateur/edit-collaborateur/edit-collaborateur.component';
import { ListDocumentComponent } from './components/document/list-document/list-document.component';
import { BilanAnnuelComponent } from './components/document/list-document/sous-list-document/bilan-annuel/bilan-annuel.component';
import { BilanTrimestrielComponent } from './components/document/list-document/sous-list-document/bilan-trimestriel/bilan-trimestriel.component';
import { BilanMoisComponent } from './components/document/list-document/sous-list-document/bilan-mois/bilan-mois.component';
import { SousListDocumentComponent } from './components/document/list-document/sous-list-document/sous-list-document.component';
import { AddDocumentAdminComponent } from './components/document/add-document-admin/add-document-admin.component';
import { InscriptionComponent } from './components/client/inscription/inscription.component';
import { AddCollaborateurComponent } from './components/collaborateur/add-collaborateur/add-collaborateur.component';
import { CollaborateurService } from './services/collaborateur.service';
import { ListClientNonValideComponent } from './components/client/list-client-non-valide/list-client-non-valide.component';
import { EmailComposeClientComponent } from './components/email/email-compose-client/email-compose-client.component';
import { RouterModule } from '@angular/router';
import { APP_BASE_HREF } from '../../node_modules/@angular/common';
import { AppRoutingModule } from './/app-routing.module';
import { ClientLeftSidebarComponent } from './components/client/client-left-sidebar/client-left-sidebar.component';
import { ClientPageContentComponent } from './components/client/client-page-content/client-page-content.component';
import {Nl2BrPipeModule} from 'nl2br-pipe';
import { ProfileClientComponent } from './components/client/profile-client/profile-client.component';
import { EditClientComponent } from './components/client/edit-client/edit-client.component';
import { HomeTemplateComponent } from './components/home-template/home-template.component';
import { HomeComponent } from './components/home-template/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    DocumentComponent,
    AddDocumentComponent,
    NavbarComponent,
    ListClientComponent,
    LeftSidebarComponent,
    TemplateAdminComponent,
    AdminLeftSidebarComponent,
    AdminPageContentComponent,
    EmailComposeComponent,
    EmailReadComponent,
    EmailInboxComponent,
    StatistiqueComponent,
    CollaborateurComponent,
    ListCollaborateurComponent,
    NewCollaborateurComponent,
    ProfileCollaborateurComponent,
    EditCollaborateurComponent,
    ListDocumentComponent,
    BilanAnnuelComponent,
    BilanTrimestrielComponent,
    BilanMoisComponent,
    SousListDocumentComponent,
    AddDocumentAdminComponent,
    InscriptionComponent,
    AddCollaborateurComponent,
    ListClientNonValideComponent,
    EmailComposeClientComponent,
    ClientLeftSidebarComponent,
    ClientPageContentComponent,
    ProfileClientComponent,
    EditClientComponent,
    HomeTemplateComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Nl2BrPipeModule,
    AppRoutingModule
  ],
  providers: [
    ClientService,
    DocumentService,
    CollaborateurService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
