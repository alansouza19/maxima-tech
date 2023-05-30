package maxima.tech.service;

import maxima.tech.dto.ClientesDTO;
import maxima.tech.model.ClientesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import maxima.tech.repository.ClientesRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientesService {

    @Autowired
    ClientesRepository clientesRepository;


    public ClientesModel cadastrar(ClientesModel clientesModel) throws Exception {
        validarCadastroCliente(clientesModel);
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

    private void validarCadastroCliente(ClientesModel clientesModel) throws Exception{
        if(clientesModel.getNome() == null){
            throw new Exception("Nome não pode ser vazio");
        }
        if(clientesModel.getCnpj() != null) {
            Pattern pattern = Pattern.compile("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(clientesModel.getCnpj());
            boolean matchRegexCnpj = matcher.find();
            if(!matchRegexCnpj) {
                throw new Exception("Informar CNPJ no formato 00.000.000/0000-00");
            }
        }
        if(clientesModel.getEndereco() == null){
            throw new Exception("Endereço não pode ser vazio");
        }
    }
}
