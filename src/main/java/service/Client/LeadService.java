package service.Client;

import domains.Client.Lead;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface LeadService extends Service<Lead, Integer> {
    Set<Lead> getAll();
}