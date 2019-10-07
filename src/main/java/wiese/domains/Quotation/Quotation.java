package wiese.domains.Quotation;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Quotation {

    @Id
    private String quotationId, quotationDate;
    @OneToMany()
    private String desc;

    public Quotation() {
    }

    public Quotation(Builder builder) {
        this.quotationId = builder.quotationId;
        this.quotationDate = builder.quotationDate;
        this.desc = builder.desc;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "quotationId='" + quotationId + '\'' +
                "quotationDate='" + quotationDate + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String quotationId,quotationDate, desc;

        public Builder quotationId(String quotationId) {
            this.quotationId = quotationId;
            return this;
        }

        public Builder quotationDate(String quotationDate) {
            this.quotationDate = quotationDate;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Quotation quotation){
            this.quotationId = quotation.quotationId;
            this.desc = quotation.desc;
            return this;
        }

        public Quotation build() {
            return new Quotation(this);
        }
    }

}
