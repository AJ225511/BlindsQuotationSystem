package wiese.domains.Quotation;

import java.util.Objects;

public class Quotation {

    private String quotationId, quotationDate;

    public Quotation() {
    }

    public Quotation(Builder builder) {
        this.quotationId = builder.quotationId;
        this.quotationDate = builder.quotationDate;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public String getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public static class Builder {

        private String quotationId, quotationDate;

        public Builder quotationId(String quotationId) {
            this.quotationId = quotationId;
            return this;
        }

        public Builder quotationDate(String quotationDate) {
            this.quotationDate = quotationDate;
            return this;
        }

        public Quotation build() {
            return new Quotation(this);
        }


        @Override
        public String toString() {
            return "Quotation{" +
                    "quotationId='" + quotationId + '\'' +
                    ", quotationDate='" + quotationDate + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Quotation quotation = (Quotation) o;
            return quotationId.equals(quotation.quotationId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(quotationId);
        }
    }

}
