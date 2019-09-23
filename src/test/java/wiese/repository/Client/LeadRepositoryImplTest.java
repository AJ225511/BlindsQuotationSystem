package wiese.repository.Client;

import wiese.domains.Client.Lead;
import wiese.factories.Client.LeadFactory;
import wiese.repository.impl.LeadRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class LeadRepositoryImplTest {

    @Autowired
    private LeadRepositoryImpl leadRepository;
    private String clientId = null;

    @Test
    public void create() {

        Lead lead = LeadFactory.getLead("10 April 2019");
        leadRepository.create(lead);

        Assert.assertNotNull(leadRepository.getAll());
    }

    @Test
    public void read() {
        try {
            Lead lead = LeadFactory.getLead("10 April 2019");
            leadRepository.create(lead);

            Assert.assertNotNull(leadRepository.getAll());
            System.out.println(lead);
            Lead lead1 = leadRepository.read(Integer.parseInt(lead.getLeadId()));
            Assert.assertEquals(lead, lead1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }

    @Test
    public void update() {
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
    public void delete() {
        try {
            Lead lead = LeadFactory.getLead("10 April 2019");
            leadRepository.create(lead);

            Assert.assertNotNull(leadRepository.getAll());
            leadRepository.delete(Integer.parseInt(lead.getLeadId()));
            Lead deleted = leadRepository.find(lead.getLeadId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }


    }
}
