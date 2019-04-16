package factories.Company;

import domains.Company.Company;

public class CompanyFactory {

    public static Company getCompany(String companyName, String companyAddress){
        return new Company.Builder()
                .companyName(companyName)
                .companyAddress(companyAddress)
                .build();
    }
}
