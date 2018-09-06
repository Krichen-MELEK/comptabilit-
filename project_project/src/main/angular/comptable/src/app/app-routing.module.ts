import { EmailReadComponent } from './components/email/email-read/email-read.component';
import { EmailInboxComponent } from './components/email/email-inbox/email-inbox.component';
import { EmailComposeComponent } from './components/email/email-compose/email-compose.component';
import { AddDocumentComponent } from './components/document/add-document/add-document.component';
import { ListClientNonValideComponent } from './components/client/list-client-non-valide/list-client-non-valide.component';
import { AddDocumentAdminComponent } from './components/document/add-document-admin/add-document-admin.component';
import { ProfileCollaborateurComponent } from './components/collaborateur/profile-collaborateur/profile-collaborateur.component';
import { AddCollaborateurComponent } from './components/collaborateur/add-collaborateur/add-collaborateur.component';
import { ListCollaborateurComponent } from './components/collaborateur/list-collaborateur/list-collaborateur.component';
import { ListClientComponent } from './components/client/list-client/list-client.component';
import { InscriptionComponent } from './components/client/inscription/inscription.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TemplateAdminComponent } from './components/admin/template-admin.component';
import { ClientComponent } from './components/client/client.component';
import { CollaborateurComponent } from './components/collaborateur/collaborateur.component';
import { DocumentComponent } from './components/document/document.component';
import { EmailComposeClientComponent } from './components/email/email-compose-client/email-compose-client.component';



const routes: Routes = [
  { path: 'admin', component: TemplateAdminComponent, children:[
    { path: 'client-list', component: ListClientComponent },
    { path: 'client-list-attente', component: ListClientNonValideComponent },
    { path: 'collaborateur-list', component: ListCollaborateurComponent },
    { path: 'collaborateur-new', component: AddCollaborateurComponent },
    { path: 'email-compose', component: EmailComposeComponent},
    { path: 'email-inbox', component: EmailInboxComponent},
    { path: 'email-read', component: EmailReadComponent},
    { path: 'document-add', component: AddDocumentAdminComponent}
    ] 
  },
  { path: 'client', component: ClientComponent,children:[
    {path: 'email-compose', component: EmailComposeClientComponent},
    {path: 'email-read/:id', component: EmailReadComponent},
    {path: 'email-inbox', component: EmailInboxComponent},
    {path: 'document-add', component: AddDocumentComponent},
    {path: 'document', component: DocumentComponent}
   ]
  },
  { path: 'collaborateur', component: CollaborateurComponent,children: [
    { path: 'client-list', component: ListClientComponent },
    { path: 'client-list-attente', component: ListClientNonValideComponent },
    { path: 'collaborateur-list', component: ListCollaborateurComponent },
    { path: 'collaborateur-new', component: AddCollaborateurComponent },
    { path: 'email-compose', component: EmailComposeComponent},
    { path: 'email-inbox', component: EmailInboxComponent},
    { path: 'email-read', component: EmailReadComponent},
    { path: 'document-add', component: AddDocumentAdminComponent}
   ]
  },
  { path: '', redirectTo: '/admin', pathMatch: 'full' },
  { path: '**', component: InscriptionComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }