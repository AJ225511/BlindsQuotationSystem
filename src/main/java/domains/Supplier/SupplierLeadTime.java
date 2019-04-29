package domains.Supplier;

public class SupplierLeadTime {

    private String leadTimeId;

    public SupplierLeadTime(){}

    public SupplierLeadTime(Builder builder){
        this.leadTimeId=builder.leadTimeId;
    }

    public String getLeadTimeId(){
        return leadTimeId;
    }

    public void setLeadTimeId(String leadTimeId) {
        this.leadTimeId = leadTimeId;
    }

    public static class Builder{

        private String leadTimeId;

        public Builder leadTimeId(String leadTimeId){
            this.leadTimeId=leadTimeId;
            return this;
        }

        public SupplierLeadTime build() {
            return new SupplierLeadTime(this);
        }
    }

    @Override
    public String toString() {
        return "SupplierLeadTime{" +
                "leadTimeId='" + leadTimeId + '\'' +
                '}';
    }
}
