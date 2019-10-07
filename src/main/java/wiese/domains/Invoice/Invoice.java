package wiese.domains.Invoice;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Invoice {

    @Id
    private String invoiceId, invoiceDate, invoiceItems;
    @OneToMany()
    private String desc;

    public Invoice() {
    }

    public Invoice(Builder builder) {
        this.invoiceId = builder.invoiceId;
        this.invoiceDate=builder.invoiceDate;
        this.invoiceItems=builder.invoiceItems;
        this.desc = builder.desc;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getInvoiceItems() {
        return invoiceItems;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                "invoiceDate='" + invoiceDate + '\'' +
                "invoiceId='" + invoiceId + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String invoiceId,invoiceDate, invoiceItems, desc;

        public Builder invoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }

        public Builder invoiceDate(String invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder invoiceItems(String invoiceItems) {
            this.invoiceItems = invoiceItems;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Invoice invoice){
            this.invoiceId = invoice.invoiceId;
            this.invoiceDate=invoice.invoiceDate;
            this.invoiceItems=invoice.invoiceItems;
            this.desc = invoice.desc;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }

}
