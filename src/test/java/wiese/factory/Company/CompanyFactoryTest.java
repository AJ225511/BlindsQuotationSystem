package wiese.factory.Company;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Company.Company;
import wiese.factories.Company.CompanyFactory;

public class CompanyFactoryTest {
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void getCompany(){

        Company company = CompanyFactory.getCompany("Taylor Blinds", "12 Bratton Way");
        Assert.assertNotNull(company.getCompanyId());
        System.out.println(company.getCompanyName());
    }
}
