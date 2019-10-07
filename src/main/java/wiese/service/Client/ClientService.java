package wiese.service.Client;

import wiese.domains.Client.Client;
import wiese.service.Service;

import java.util.List;

public interface ClientService extends Service<Client, String> {
    Client retrieveByDesc(String clientDesc);
    List<Client> getAll();
}
