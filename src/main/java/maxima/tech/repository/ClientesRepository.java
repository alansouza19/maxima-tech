package maxima.tech.repository;

import maxima.tech.model.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, UUID> {

}
