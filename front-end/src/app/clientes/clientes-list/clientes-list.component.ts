import { ClientesService } from '../shared/clientes.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Clientes } from '../shared/clientes';
import {Router} from "@angular/router";


@Component({
  selector: 'app-clientes-list',
  templateUrl: './clientes-list.component.html',
  styleUrls: ['./clientes-list.component.css']
})
export class ClientesListComponent implements OnInit {
  @Input()
  clientes: Clientes[] = [];
  readonly displayedColumns = [
    'codigo', 'nome', 'cnpj', 'endereco', 'acoes'
  ];

  constructor(
    private router: Router,
    private clientesService: ClientesService,
  ) { }

  ngOnInit() {
    this.buscarClientes();
  }
  remove(clientes: Clientes) {
    this.clientesService.delete(clientes.id).subscribe(() => {
      this.clientes = this.clientes.filter(c => c.id !== clientes.id);
    });

  }
  buscarClientes(): void {
    this.clientesService.getAll()
      .subscribe(
        (clientes: Clientes[]) => {
          this.clientes = clientes;
        },
        (error) => {
          console.error(error);
        }
      );
  }
}

