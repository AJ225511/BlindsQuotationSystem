package service.Client;

import domains.Client.Client;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface ClientService extends Service<Client, Integer> {
    Set<Client> getAll();
}
