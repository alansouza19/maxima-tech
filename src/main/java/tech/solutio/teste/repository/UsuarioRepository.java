package tech.solutio.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.solutio.teste.model.UserModel;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByLogin(String username);
}
