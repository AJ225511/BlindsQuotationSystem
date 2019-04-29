package domains.Client;

public class Lead {

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

    public void setLeadId(String leadId){this.leadId = leadId;}

    public static class Builder{

        private String leadId, leadDate;

        public Builder leadId(String leadId){
            this.leadId=leadId;
            return this;
        }

        public Builder leadDate(String leadDate){
            this.leadDate=leadDate;
            return this;
        }

        public Lead build(){
            return new Lead(this);
        }
    }

    @Override
    public String toString() {
        return "Lead{" +
                "leadId='" + leadId + '\'' +
                ", leadDate='" + leadDate + '\'' +
                '}';
    }


}
