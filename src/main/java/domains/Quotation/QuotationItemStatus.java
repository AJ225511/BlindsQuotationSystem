package domains.Quotation;

public class QuotationItemStatus extends Quotation {

    private String quotationItemStatusId;

    public QuotationItemStatus(){}

    public QuotationItemStatus(Builder builder){
        super(builder);
        this.quotationItemStatusId=builder.quotationItemStatusId;
    }

    public String getQuotationItemStatusId(){
        return quotationItemStatusId;
    }

    public static class Builder extends Quotation.Builder{

        private String quotationItemStatusId;

        public Builder quotationItemStatusId(String quotationItemStatusId){
            this.quotationItemStatusId=quotationItemStatusId;
            return this;
        }

        @Override
        public Quotation build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "QuotationItemStatus{" +
                "quotationItemStatusId='" + quotationItemStatusId + '\'' +
                '}';
    }
}
