package wiese.repository.Client;

import wiese.domains.Client.Lead;
import wiese.repository.Repository;

import java.util.Set;

public interface LeadRepository extends Repository <Lead, Integer> {
    Set<Lead> getAll();
}
