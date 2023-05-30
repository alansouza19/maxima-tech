import { ClientesService } from '../shared/clientes.service';
import { Component, OnInit } from '@angular/core';
import { Clientes } from '../shared/clientes';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {
  clientes: Clientes = new Clientes();
  title = 'Novo cliente';

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private clientesService: ClientesService
  ) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id) {
      this.clientesService.getById(id).subscribe(clientes => {
        this.clientes = clientes;
        this.title = 'Alterar dados do cliente';
      });
    }
  }

  onSubmit() {
    this.clientesService.save(this.clientes).subscribe(clientes => {
      console.log(clientes);
      this.router.navigate(['/lista-clientes']);
    });
  }

}
