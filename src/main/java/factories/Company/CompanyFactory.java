package factories.Company;

import domains.Company.Company;
import util.Misc;

public class CompanyFactory {

    public static Company getCompany(String companyName, String companyAddress){
        return new Company.Builder()
                .companyName(companyName)
                .companyAddress(companyAddress)
                .companyId(Misc.generateId())
                .build();
    }
}
