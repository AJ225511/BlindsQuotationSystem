package wiese.service.impl;

import wiese.domains.Client.Client;
import wiese.repository.Client.ClientRepository;
import wiese.repository.impl.ClientRepositoryImpl;
import wiese.service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ClientServiceImpl")
public class ClientServiceImpl implements ClientService {

    private ClientServiceImpl service = null;
    private ClientRepository repository;
    private Integer id;

    public ClientServiceImpl() {
        repository = ClientRepositoryImpl.getRepository();
    }

    public ClientService getService() {
        if (service == null) service = new ClientServiceImpl();
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
