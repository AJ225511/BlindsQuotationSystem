package wiese.domains.Quotation;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class QuotationItemStatus extends Quotation {

    @Id
    private String quotationStatusId;
    @OneToMany()
    private String desc;

    public QuotationItemStatus() {
    }

    public QuotationItemStatus(Builder builder) {
        this.quotationStatusId = builder.quotationStatusId;
        this.desc = builder.desc;
    }

    public String getQuotationItemStatusId() {
        return quotationStatusId;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "QuotationItemStatus{" +
                "quotationStatusId='" + quotationStatusId + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String quotationStatusId, desc;

        public Builder quotationStatusId(String quotationStatusId) {
            this.quotationStatusId = quotationStatusId;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(QuotationItemStatus quotationStatus){
            this.quotationStatusId = quotationStatus.quotationStatusId;
            this.desc = quotationStatus.desc;
            return this;
        }

        public QuotationItemStatus build() {
            return new QuotationItemStatus(this);
        }
    }

}

