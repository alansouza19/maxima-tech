package tech.solutio.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.solutio.teste.model.UserModel;
import tech.solutio.teste.service.UsuarioService;

import java.util.UUID;

@RequestMapping("/v1/usuario")
@RestController
public class UsuarioModelController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public UserModel cadastrar(@RequestBody UserModel userModel){
        return usuarioService.cadastrar(userModel);
    }
}
