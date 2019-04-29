package domains.Company;

public class Company {

    private String companyName, companyAddress, companyId;

    public Company(){}

    public Company(Builder builder){
        this.companyName = builder.companyName;
        this.companyAddress = builder.companyAddress;
        this.companyId = builder.companyId;
    }

    public String getCompanyAddress(){
        return companyAddress;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getCompanyId() {return companyId;}

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public static class Builder{

        private String companyName, companyAddress, companyId;

        public Builder companyName(String companyName){
            this.companyName=companyName;
            return this;
        }

        public Builder companyAddress(String companyAddress){
            this.companyAddress=companyAddress;
            return this;
        }

        public Builder companyId(String companyId){
            this.companyId =companyId;
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
                ", companyId='" + companyId + '\'' +
                '}';
    }

}
