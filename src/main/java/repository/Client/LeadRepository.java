package repository.Client;

import domains.Client.Lead;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface LeadRepository extends Repository <Lead, Integer> {
    Set<Lead> getAll();
}
