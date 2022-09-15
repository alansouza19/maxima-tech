package tech.solutio.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.solutio.teste.model.ProdutosModel;

import java.util.UUID;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, UUID> {

}
