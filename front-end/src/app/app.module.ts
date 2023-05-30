import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {ClientesListComponent} from "./clientes/clientes-list/clientes-list.component";
import {HomeComponent} from "./layout/home/home.component";
import {ClientesFormComponent} from "./clientes/clientes-form/clientes-form.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';


@NgModule({
  declarations: [
    AppComponent,
    ClientesListComponent,
    ClientesFormComponent,
    HomeComponent,
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatTableModule,
        CommonModule,
        ReactiveFormsModule,



    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
