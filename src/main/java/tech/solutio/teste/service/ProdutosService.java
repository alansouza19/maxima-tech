package tech.solutio.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.solutio.teste.model.ProdutosModel;
import tech.solutio.teste.repository.ProdutosRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutosService {

    @Autowired
    ProdutosRepository produtosRepository;


    public ProdutosModel cadastrar(ProdutosModel produtosModel) {
        return produtosRepository.save(produtosModel);
    }


    public List<ProdutosModel> findAll() {
        return produtosRepository.findAll();
    }

    public Optional<ProdutosModel> findById(UUID id) {
        return produtosRepository.findById(id);
    }


    public void delete(ProdutosModel produtosModel) {
        produtosRepository.delete(produtosModel);
    }
}
