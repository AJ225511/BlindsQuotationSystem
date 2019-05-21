package wiese.service.Client;

import wiese.domains.Client.Client;
import wiese.service.Service;

import java.util.Set;

public interface ClientService extends Service<Client, Integer> {
    Set<Client> getAll();
}
