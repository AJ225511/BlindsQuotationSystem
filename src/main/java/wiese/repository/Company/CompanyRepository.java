package wiese.repository.Company;

import wiese.domains.Company.Company;
import wiese.repository.Repository;

import java.util.Set;

public interface CompanyRepository extends Repository <Company, Integer> {
    Set<Company> getAll();
}
