package domains.Quotation;

public class QuotationItem extends Quotation {

    private String quotationItemId;

    public QuotationItem(){}

    public QuotationItem(Builder builder){
        super(builder);
        this.quotationItemId=builder.quotationItemId;
    }

    public String getQuotationItemId(){
        return quotationItemId;
    }

    public static class Builder extends Quotation.Builder{

        private String quotationItemId;

        public Builder quotationItemId(String quotationItemId){
            this.quotationItemId=quotationItemId;
            return this;
        }

        @Override
        public Quotation build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "QuotationItem{" +
                "quotationItemId='" + quotationItemId + '\'' +
                '}';
    }
}
