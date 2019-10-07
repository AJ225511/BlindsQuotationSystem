package wiese.service.Client;

import wiese.domains.Client.Lead;
import wiese.service.Service;

import java.util.List;


public interface LeadService extends Service<Lead, String> {
    Lead retrieveByDesc(String leadDesc);
    List<Lead> getAll();
}