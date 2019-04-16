package domains.Company;

public class Company {

    private String companyName, companyAddress;

    public Company(){}

    public Company(Builder builder){
        this.companyName = builder.companyName;
        this.companyAddress = builder.companyAddress;
    }

    public String getCompanyAddress(){
        return companyAddress;
    }

    public String getCompanyName(){
        return companyName;
    }

    public static class Builder{

        private String companyName, companyAddress;

        public Builder companyName(String companyName){
            this.companyName=companyName;
            return this;
        }

        public Builder companyAddress(String companyAddress){
            this.companyAddress=companyAddress;
            return this;
        }

        public Company build(){
            return new Company(this);
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                '}';
    }

}
