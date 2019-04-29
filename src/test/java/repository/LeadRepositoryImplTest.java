package repository;

import domains.Client.Lead;
import factories.Client.LeadFactory;
import repository.impl.LeadRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeadRepositoryImplTest {

    LeadRepositoryImpl leadRepository;

    @Before
    public void setUp() throws Exception{
        leadRepository = LeadRepositoryImpl.getRepository();
    }

    @Test
    public void create(){

        Lead lead = LeadFactory.getLead("10 April 2019");
        leadRepository.create(lead);

        Assert.assertNotNull(leadRepository.getAll());
    }

    @Test
    public void read(){
        try {
            Lead lead = LeadFactory.getLead("10 April 2019");
            leadRepository.create(lead);

            Assert.assertNotNull(leadRepository.getAll());
            System.out.println(lead);
            Lead lead1 = leadRepository.read(Integer.parseInt(lead.getLeadId()));
            Assert.assertEquals(lead, lead1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }

    @Test
    public void update(){
        Lead lead = LeadFactory.getLead("10 April 2019");
        leadRepository.create(lead);

        Assert.assertNotNull(leadRepository.getAll());
        Lead lead1 = LeadFactory.getLead("11 April 2019");
        lead1.setLeadId(lead.getLeadId());
        leadRepository.update(lead1);

        Lead updatedLead = leadRepository.find(lead1.getLeadId());
        Assert.assertEquals(lead1, updatedLead);
        System.out.println(updatedLead);
    }

    @Test
    public void delete(){
        try {
            Lead lead = LeadFactory.getLead("10 April 2019");
            leadRepository.create(lead);

            Assert.assertNotNull(leadRepository.getAll());
            leadRepository.delete(Integer.parseInt(lead.getLeadId()));
            Lead deleted = leadRepository.find(lead.getLeadId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }


    }
}
