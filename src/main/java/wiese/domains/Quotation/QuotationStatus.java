package wiese.domains.Quotation;

import javax.persistence.Id;
import javax.persistence.OneToMany;


public class QuotationStatus extends Quotation {

    @Id
    private String quotationStatusId;
    @OneToMany()
    private String desc;

    public QuotationStatus() {
    }

    public QuotationStatus(Builder builder) {
        this.quotationStatusId = builder.quotationStatusId;
        this.desc = builder.desc;
    }

    public String getQuotationStatusId() {
        return quotationStatusId;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "QuotationStatus{" +
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

        public Builder copy(QuotationStatus quotationStatus){
            this.quotationStatusId = quotationStatus.quotationStatusId;
            this.desc = quotationStatus.desc;
            return this;
        }

        public QuotationStatus build() {
            return new QuotationStatus(this);
        }
    }

}

