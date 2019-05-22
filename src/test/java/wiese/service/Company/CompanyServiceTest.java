package wiese.service.Company;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Company.Company;
import wiese.factories.Company.CompanyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.CompanyServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {
    @Autowired
    private CompanyServiceImpl companyService;

    @Test
    public void create(){
        Company company = CompanyFactory.getCompany("Bay View Blinds", "12 Bratton Way");
        companyService.create(company);

        assertNotNull(companyService.getAll());
        System.out.println(company);
    }

    @Test
    public void read(){
        try {
            Company company = CompanyFactory.getCompany("Table Bay Blinds", "7 Castle Road");
            companyService.create(company);

            Company company1 = companyService.read(Integer.parseInt(company.getCompanyId()));
            assertEquals(company, company1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            Company company = CompanyFactory.getCompany("Bay View Blinds", "12 Bratton Way");
            companyService.create(company);

            Company company1 = CompanyFactory.getCompany("Taylor Blinds", "2 Round Drive");
            company1.setCompanyId(company.getCompanyId());
            companyService.update(company1);
            System.out.println("Original: \n"+company);
            System.out.println("Updated: \n"+company1);

            Company company2 = companyService.read(Integer.parseInt(company1.getCompanyId()));
            assertEquals(company1, company2);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }
    @Test
    public void delete(){
        try {
            Company company = CompanyFactory.getCompany("Taylor Blinds", "2 Round Drive");
            companyService.create(company);

            assertNotNull(companyService.getAll());
            Company company1 = companyService.read(Integer.parseInt(company.getCompanyId()));
            assertNull(company1);
        }catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }
}
