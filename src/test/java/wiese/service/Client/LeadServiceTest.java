//package wiese.service.Client;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import wiese.domains.Client.Lead;
//import wiese.factories.Client.LeadFactory;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import wiese.service.impl.LeadServiceImpl;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LeadServiceTest {
//    @Autowired
//    private LeadServiceImpl leadService;
//
//    @Test
//    public void create() {
//        Lead lead = LeadFactory.getLead("12 April 2019");
//        leadService.create(lead);
//
//        assertNotNull(leadService.getAll());
//        System.out.println(lead);
//    }
//
//    @Test
//    public void read() {
//        try {
//            Lead lead = LeadFactory.getLead("13 April 2019");
//            leadService.create(lead);
//
//            Lead lead1 = leadService.read(Integer.parseInt(lead.getLeadId()));
//            assertEquals(lead, lead1);
//        } catch (NumberFormatException nfe) {
//            System.out.println(nfe);
//        }
//
//    }
//
//    @Test
//    public void update() {
//        try {
//            Lead lead = LeadFactory.getLead("11 June 2019");
//            leadService.create(lead);
//
//            Lead lead1 = LeadFactory.getLead("12 June 2019");
//            lead1.setLeadId(lead.getLeadId());
//            leadService.update(lead1);
//            System.out.println("Original: \n" + lead);
//            System.out.println("Updated: \n" + lead1);
//
//            Lead lead2 = leadService.read(Integer.parseInt(lead1.getLeadId()));
//            assertEquals(lead1, lead2);
//        } catch (NumberFormatException nfe) {
//            System.out.println(nfe);
//        }
//    }
//
//    @Test
//    public void delete() {
//        try {
//            Lead lead = LeadFactory.getLead("10 June 2019");
//            leadService.create(lead);
//
//            assertNotNull(leadService.getAll());
//            Lead lead1 = leadService.read(Integer.parseInt(lead.getLeadId()));
//            assertNull(lead1);
//        } catch (NumberFormatException nfe) {
//            System.out.println(nfe);
//        }
//    }
//}

