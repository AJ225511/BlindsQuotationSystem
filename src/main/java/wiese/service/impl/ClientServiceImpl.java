package wiese.service.impl;

import wiese.domains.Client.Client;
import wiese.repository.Client.ClientRepository;
import wiese.service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private static ClientServiceImpl clientService = null;
    @Autowired
    private ClientRepository clientRepository;

    private ClientServiceImpl() {

    }

    public static ClientService getClientService() {
        if (clientService == null) clientService = new ClientServiceImpl();
        return clientService;
    }

    @Override
    public Client create(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Client read(String s){
        Optional<Client> client = this.clientRepository.findById(s);
        return client.orElse(null);
    }

    @Override
    public Client update(Client client){
        return this.clientRepository.save(client);
    }

    @Override
    public void delete(String s){
        this.clientRepository.deleteById(s);
    }

    @Override
    public Client retrieveByDesc(String assembleDesc){
        List<Client> clientes = getAll();
        for(Client client: clientes){
            if(client.getDesc().equalsIgnoreCase(assembleDesc)) return client;
        }
        return null;
    }

    @Override
    public List<Client> getAll(){
        return this.clientRepository.findAll();
    }
}
