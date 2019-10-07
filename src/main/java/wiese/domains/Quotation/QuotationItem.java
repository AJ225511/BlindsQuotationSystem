package wiese.domains.Quotation;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class QuotationItem extends Quotation {

    @Id
    private String quotationItemId;
    @OneToMany()
    private String desc;

    public QuotationItem() {
    }

    public QuotationItem(Builder builder) {
        this.quotationItemId = builder.quotationItemId;
        this.desc = builder.desc;
    }

    public String getQuotationItemId() {
        return quotationItemId;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "QuotationItem{" +
                "quotationItemId='" + quotationItemId + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String quotationItemId, desc;

        public Builder quotationItemId(String quotationItemId) {
            this.quotationItemId = quotationItemId;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(QuotationItem quotationItem){
            this.quotationItemId = quotationItem.quotationItemId;
            this.desc = quotationItem.desc;
            return this;
        }

        public QuotationItem build() {
            return new QuotationItem(this);
        }
    }

}

