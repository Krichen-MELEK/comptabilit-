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



const routes: Routes = [
  { path: 'admin', component: TemplateAdminComponent, children:[
    { path: 'clients', children:[
      {path:'list' ,outlet: 'contentTemplateAdmin', component: ListClientComponent},
      {path:'listEnAttente' , outlet: 'contentTemplateAdmin', component: ListClientNonValideComponent}
    ]},
    { path: 'email',  children:[
      {path:'compose',outlet: 'contentTemplateAdmin', component: EmailComposeComponent },
      {path:'read',outlet: 'contentTemplateAdmin', component: EmailReadComponent },
      {path:'inbox',outlet: 'contentTemplateAdmin', component: EmailInboxComponent }
    ]},
    { path: 'collaborateurs',  children:[
      {path:'list',outlet: 'contentTemplateAdmin', component: ListCollaborateurComponent },
      {path:'add',outlet: 'contentTemplateAdmin', component: AddCollaborateurComponent }
    ]},
    { path: 'document',  children:[
      {path:'add',outlet: 'contentTemplateAdmin', component: AddDocumentComponent }
    ]}
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