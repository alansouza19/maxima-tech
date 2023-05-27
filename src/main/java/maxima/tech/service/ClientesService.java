package maxima.tech.service;

import maxima.tech.model.ClientesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import maxima.tech.repository.ClientesRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientesService {

    @Autowired
    ClientesRepository clientesRepository;


    public ClientesModel cadastrar(ClientesModel clientesModel) {
        return clientesRepository.save(clientesModel);
    }


    public List<ClientesModel> findAll() {
        return clientesRepository.findAll();
    }

    public Optional<ClientesModel> findById(UUID id) {
        return clientesRepository.findById(id);
    }


    public void delete(ClientesModel clientesModel) {
        clientesRepository.delete(clientesModel);
    }
}
