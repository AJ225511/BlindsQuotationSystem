package service.impl;

import domains.Client.Client;
import repository.Client.ClientRepository;
import repository.impl.ClientRepositoryImpl;
import service.Client.ClientService;

import java.util.Set;

public class ClientServiceImpl implements ClientService {

    private ClientServiceImpl service = null;
    private ClientRepository repository;
    private Integer id;

    public ClientServiceImpl(){
        repository = ClientRepositoryImpl.getRepository();
    }

    public ClientService getService(){
        if(service == null) service = new ClientServiceImpl();
        return service;
    }

    @Override
    public Set<Client> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Client create(Client client) {
        return this.repository.create(client);
    }

    @Override
    public Client update(Client client) {
        return this.repository.update(client);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Client read(Integer integer) {
        return this.repository.read(id);
    }
}
