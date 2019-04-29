package service.Company;

import domains.Company.Company;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface CompanyService extends Service<Company, Integer> {
    Set<Company> getAll();
}
