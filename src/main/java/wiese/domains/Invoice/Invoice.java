package wiese.domains.Invoice;

import java.util.Objects;

public class Invoice {

    private String invoiceId,invoiceDate,invoiceItems;

    public Invoice(){}

    public Invoice(Builder builder){
        this.invoiceDate = builder.invoiceDate;
        this.invoiceId = builder.invoiceId;
        this.invoiceItems = builder.invoiceItems;
    }

    public String getInvoiceId(){
        return invoiceId;
    }

    public String getInvoiceDate(){
        return invoiceDate;
    }

    public String getInvoiceItems(){
        return invoiceItems;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public static class Builder{

        private String invoiceId, invoiceDate, invoiceItems;

        public Builder invoiceId(String invoiceId){
            this.invoiceId=invoiceId;
            return this;
        }

        public Builder invoiceDate(String invoiceDate){
            this.invoiceDate=invoiceDate;
            return this;
        }

        public Builder invoiceItems(String invoiceItems){
            this.invoiceItems=invoiceItems;
            return this;
        }

        public Invoice build(){
            return new Invoice(this);
        }


    }
    @Override
    public String toString(){
        return "Invoice{"+
                "invoiceId: '"+ invoiceId + '\''+
                ", invoiceDate: '" + invoiceDate +'\'' +
                ", invoiceItems: '" + invoiceItems +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId.equals(invoice.invoiceId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(invoiceId);
    }
}
