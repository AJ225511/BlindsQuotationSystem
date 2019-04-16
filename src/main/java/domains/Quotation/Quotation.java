package domains.Quotation;

public abstract class Quotation {

    private String quotationId, quotationDate;

    public Quotation(){}

    public Quotation(Builder builder){
        this.quotationId = builder.quotationId;
        this.quotationDate = builder.quotationDate;
    }

    public String getQuotationId(){return quotationId;}

    public String getQuotationDate(){return quotationDate;}

    public static abstract class Builder{

        private String quotationId, quotationDate;

        public Builder quotationId(String quotationId){
            this.quotationId=quotationId;
            return this;
        }

        public Builder quotationDate(String quotationDate){
            this.quotationDate=quotationDate;
            return this;
        }

        public abstract Quotation build();


        @Override
        public String toString() {
            return "Quotation{" +
                    "quotationId='" + quotationId + '\'' +
                    ", quotationDate='" + quotationDate + '\'' +
                    '}';
        }
    }
}
