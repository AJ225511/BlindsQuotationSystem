package wiese.repository.Client;

import wiese.domains.Client.Client;
import wiese.repository.Repository;

import java.util.Set;

public interface ClientRepository extends Repository<Client, Integer> {
    Set<Client> getAll();
}
