import { environment } from '../../../environments/environment';
import { Clientes } from './clientes';
import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, map, Observable, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Clientes[]> {

    return this.http.get<Clientes[]>(`${environment.api}/api/clientes`);
  }

  getById(id: string): Observable<any> {
    return this.http.get<Clientes>(`${environment.api}/api/clientes/${id}`);
  }

  save(clientes: Clientes) {
    const clientesBody = {
      codigo: clientes.codigo,
      nome: clientes.nome,
      cnpj: clientes.cnpj,
      endereco: clientes.endereco
    };

    if (clientes.id) {
      return this.http.put<Clientes>(`${environment.api}/api/clientes/${clientes.id}`, clientesBody);

    } else {
      return this.http.post<Clientes>(`${environment.api}/api/clientes/cadastro`, clientesBody);
    }
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${environment.api}/api/clientes/delete/${id}`);
  }
}
