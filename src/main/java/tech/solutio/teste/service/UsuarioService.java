package tech.solutio.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.solutio.teste.model.UserModel;
import tech.solutio.teste.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;

    public UserModel cadastrar(UserModel userModel){

        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return usuarioRepository.save(userModel);
    }


}
