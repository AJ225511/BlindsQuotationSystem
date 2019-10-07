package wiese.service.Company;

import wiese.domains.Company.Company;
import wiese.service.Service;

import java.util.List;

public interface CompanyService extends Service<Company, String> {
    Company retrieveByDesc(String companyDesc);
    List<Company> getAll();
}
