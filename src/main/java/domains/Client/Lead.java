package domains.Client;

public abstract class Lead {

    private String leadId, leadDate;

    public Lead(){}

    public Lead(Builder builder){
        this.leadDate = builder.leadDate;
        this.leadId = builder.leadId;
    }

    public String getLeadId(){
        return leadId;
    }

    public String getLeadDate(){
        return leadDate;
    }

    public abstract static class Builder{

        private String leadId, leadDate;

        public Builder leadId(String leadId){
            this.leadId=leadId;
            return this;
        }

        public Builder leadDate(String leadDate){
            this.leadDate=leadDate;
            return this;
        }

        public abstract Lead build();
    }

    @Override
    public String toString() {
        return "Lead{" +
                "leadId='" + leadId + '\'' +
                ", leadDate='" + leadDate + '\'' +
                '}';
    }


}
