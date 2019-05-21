package wiese.service.Client;

import wiese.domains.Client.Lead;
import wiese.service.Service;

import java.util.Set;

public interface LeadService extends Service<Lead, Integer> {
    Set<Lead> getAll();
}