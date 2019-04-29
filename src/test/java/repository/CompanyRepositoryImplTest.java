package repository;

import domains.Company.Company;
import factories.Company.CompanyFactory;
import repository.impl.CompanyRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyRepositoryImplTest {

    CompanyRepositoryImpl companyRepository;

    @Before
    public void setUp() throws Exception{
        companyRepository = CompanyRepositoryImpl.getRepository();
    }

    @Test
    public void create(){

        Company company = CompanyFactory.getCompany("AJ's Steakhouse", "West Beach");
        companyRepository.create(company);

        Assert.assertNotNull(companyRepository.getAll());
    }

    @Test
    public void read(){
        try {
            Company company = CompanyFactory.getCompany("AJ's Steakhouse", "West Beach");
            companyRepository.create(company);

            Assert.assertNotNull(companyRepository.getAll());
            System.out.println(company);

            Company company1 = companyRepository.read(Integer.parseInt(company.getCompanyId()));
            Assert.assertEquals(company, company1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update(){

        Company company = CompanyFactory.getCompany("AJ's Steakhouse", "West Beach");
        companyRepository.create(company);

        Assert.assertNotNull(companyRepository.getAll());
        Company company1 = CompanyFactory.getCompany("JJ's Steakhouse", "Parklands");
        company1.setCompanyId(company.getCompanyId());
        companyRepository.update(company1);

        Company updatedCompany = companyRepository.find(company1.getCompanyId());
        Assert.assertEquals(company1, updatedCompany);

        System.out.println(updatedCompany);

    }

    @Test
    public void delete(){
        try {
            Company company = CompanyFactory.getCompany("AJ's Steakhouse", "West Beach");
            companyRepository.create(company);

            Assert.assertNotNull(companyRepository.getAll());
            companyRepository.delete(Integer.parseInt(company.getCompanyId()));
            Company deleted = companyRepository.find(company.getCompanyId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }


    }
}

