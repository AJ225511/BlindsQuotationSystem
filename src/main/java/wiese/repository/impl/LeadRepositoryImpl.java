package wiese.repository.impl;

import wiese.domains.Client.Lead;
import wiese.repository.Client.LeadRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("LeadInMemory")
public class LeadRepositoryImpl implements LeadRepository {

    private static LeadRepositoryImpl repository = null;
    private Set<Lead> leads;

    private LeadRepositoryImpl() {
        this.leads = new HashSet<>();
    }

    public static LeadRepositoryImpl getRepository() {
        if (repository == null) repository = new LeadRepositoryImpl();
        return repository;
    }

    public Lead find(String id) {
        return leads.stream().filter(lead -> lead.getLeadId() == id).findAny().orElse(null);
    }

    @Override
    public Set<Lead> getAll() {
        return leads;
    }

    @Override
    public Lead create(Lead lead) {
        this.leads.add(lead);
        return lead;
    }

    @Override
    public Lead update(Lead lead) {
        Lead lead1 = find(lead.getLeadId());
        if (leads.contains(lead1)) {
            leads.remove(lead1);
            leads.add(lead);
        }
        return lead1;
    }

    @Override
    public void delete(Integer id) {

        Lead lead = find(Integer.toString(id));
        leads.remove(lead);

    }

    @Override
    public Lead read(Integer id) {
        Lead lead = find(Integer.toString(id));
        if (lead == null) {
            return null;
        } else {
            return lead;
        }
    }
}
