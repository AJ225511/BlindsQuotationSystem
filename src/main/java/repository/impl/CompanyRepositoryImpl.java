package repository.impl;

import domains.Company.Company;
import repository.Company.CompanyRepository;

import java.util.HashSet;
import java.util.Set;

public class CompanyRepositoryImpl implements CompanyRepository{

    private static CompanyRepositoryImpl repository = null;
    private Set<Company> companies;

    private CompanyRepositoryImpl(){
        this.companies = new HashSet<>();
    }

    public static CompanyRepositoryImpl getRepository(){
        if(repository == null) repository = new CompanyRepositoryImpl();
        return repository;
    }

    public Company find(String id){
        return companies.stream().filter(company -> company.getCompanyId() == id).findAny().orElse(null);
    }

    @Override
    public Set<Company> getAll() {
        return companies;
    }

    @Override
    public Company create(Company company) {
        this.companies.add(company);
        return company;
    }

    @Override
    public Company update(Company company) {
        Company company1 = find(company.getCompanyId());
        if(companies.contains(company1)){
            companies.remove(company1);
            companies.add(company);
        }
        return company1;
    }

    @Override
    public void delete(Integer id) {

        Company company = find(Integer.toString(id));
        companies.remove(company);

    }

    @Override
    public Company read(Integer id) {
        Company company = find(Integer.toString(id));
        if(company == null){
            return null;
        }
        else{
            return company;
        }
    }
}
