package wiese.repository.impl;

import wiese.domains.Client.Client;
import wiese.repository.Client.ClientRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ClientInMemory")
public class ClientRepositoryImpl implements ClientRepository {

    private static ClientRepositoryImpl repository = null;
    private Set<Client> clients;

    private ClientRepositoryImpl() {
        this.clients = new HashSet<>();
    }

    public static ClientRepositoryImpl getRepository() {
        if (repository == null) repository = new ClientRepositoryImpl();
        return repository;
    }

    public Client find(String id) {
        return clients.stream().filter(client -> client.getClientId() == id).findAny().orElse(null);
    }

    @Override
    public Set<Client> getAll() {
        return clients;
    }

    @Override
    public Client create(Client client) {
        this.clients.add(client);
        return client;
    }

    @Override
    public Client update(Client client) {
        Client client1 = find(client.getClientId());
        if (clients.contains(client1)) {
            clients.remove(client1);
            clients.add(client);
        }
        return client1;
    }

    @Override
    public void delete(Integer id) {

        Client client = find(Integer.toString(id));
        clients.remove(client);

    }

    @Override
    public Client read(Integer id) {
        Client client = find(Integer.toString(id));
        if (client == null) {
            return null;
        } else {
            return client;
        }
    }
}
