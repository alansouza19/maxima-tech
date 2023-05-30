package maxima.tech.controller;

import jakarta.validation.Valid;
import maxima.tech.dto.ClientesDTO;
import maxima.tech.model.ClientesModel;
import maxima.tech.service.ClientesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/clientes")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @PostMapping("/cadastro")
    public ResponseEntity<Object> cadastrarClientes(@RequestBody @Valid ClientesDTO clientesDTO) throws Exception {
        ClientesModel clientesModel = new ClientesModel();
        BeanUtils.copyProperties(clientesDTO, clientesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.cadastrar(clientesModel));
    }

    @GetMapping
    public ResponseEntity<List<ClientesModel>> buscarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clientesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable(value = "id") UUID id){
        Optional<ClientesModel> clientesModelOptional = clientesService.findById(id);
        if (!clientesModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientesModelOptional.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable(value = "id") UUID id){
        Optional<ClientesModel> clientesModelOptional = clientesService.findById(id);
        if (!clientesModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        clientesService.delete(clientesModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(clientesModelOptional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarClientes(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid ClientesDTO clientesDTO) throws Exception {
        Optional<ClientesModel> clientesModelOptional = clientesService.findById(id);
        if (!clientesModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        ClientesModel clientesModel = new ClientesModel();
        BeanUtils.copyProperties(clientesDTO, clientesModel);
        clientesModel.setId(clientesModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clientesService.cadastrar(clientesModel));
    }
}
