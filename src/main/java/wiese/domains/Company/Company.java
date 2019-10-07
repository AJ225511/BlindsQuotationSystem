package wiese.domains.Company;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Company {

    @Id
    private String companyName, companyAddress, companyId;
    @OneToMany()
    private String desc;

    public Company() {
    }

    public Company(Builder builder) {
        this.companyId = builder.companyId;
        this.companyAddress=builder.companyAddress;
        this.companyName=builder.companyName;
        this.desc = builder.desc;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                "companyAddress='" + companyAddress + '\'' +
                "companyName='" + companyName + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String companyId,companyName, companyAddress, desc;

        public Builder companyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder companyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Company company){
            this.companyId = company.companyId;
            this.companyAddress=company.companyAddress;
            this.companyName=company.companyName;
            this.desc = company.desc;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }

}
