package repository.Client;

import domains.Client.Client;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface ClientRepository extends Repository<Client, Integer> {
    Set<Client> getAll();
}
