package repository.Company;

import domains.Company.Company;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface CompanyRepository extends Repository <Company, Integer> {
    Set<Company> getAll();
}
