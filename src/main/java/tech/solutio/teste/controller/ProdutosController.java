package tech.solutio.teste.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.solutio.teste.dto.ProdutosDto;
import tech.solutio.teste.model.ProdutosModel;
import tech.solutio.teste.service.ProdutosService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/produtos")
public class ProdutosController {

    @Autowired
    ProdutosService produtosService;

    @PostMapping("/cadastro")
    public ResponseEntity<Object> cadastrarProdutos(@RequestBody @Valid ProdutosDto produtosDto){
        ProdutosModel produtosModel = new ProdutosModel();
        BeanUtils.copyProperties(produtosDto, produtosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosService.cadastrar(produtosModel));
    }

    @GetMapping
    public ResponseEntity<List<ProdutosModel>> buscarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable(value = "id") UUID id){
        Optional<ProdutosModel> produtosModelOptional = produtosService.findById(id);
        if (!produtosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtosModelOptional.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value = "id") UUID id){
        Optional<ProdutosModel> produtosModelOptional = produtosService.findById(id);
        if (!produtosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtosService.delete(produtosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProdutos(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid ProdutosDto produtosDto){
        Optional<ProdutosModel> produtosModelOptional = produtosService.findById(id);
        if (!produtosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        ProdutosModel produtosModel = new ProdutosModel();
        BeanUtils.copyProperties(produtosDto, produtosModel);
        produtosModel.setId(produtosModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.cadastrar(produtosModel));
    }
}
