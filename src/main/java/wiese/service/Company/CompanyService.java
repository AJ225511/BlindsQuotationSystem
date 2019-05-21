package wiese.service.Company;

import wiese.domains.Company.Company;
import wiese.service.Service;

import java.util.Set;

public interface CompanyService extends Service<Company, Integer> {
    Set<Company> getAll();
}
