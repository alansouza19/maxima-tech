
import { HomeComponent } from './layout/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesFormComponent } from './clientes/clientes-form/clientes-form.component';
import { ClientesListComponent } from './clientes/clientes-list/clientes-list.component';




const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [

      { path: 'lista-clientes', component: ClientesListComponent },
      { path: 'cadastro', component: ClientesFormComponent },
      { path: 'altera/:id', component: ClientesFormComponent }
    ],

  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
