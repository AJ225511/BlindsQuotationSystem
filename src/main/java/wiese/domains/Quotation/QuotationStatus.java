package wiese.domains.Quotation;

import java.util.Objects;

public class QuotationStatus extends Quotation {

    private String quotationStatusId;

    public QuotationStatus() {
    }

    public QuotationStatus(Builder builder) {
        super(builder);
        this.quotationStatusId = builder.quotationStatusId;
    }

    public String getQuotationStatusId() {
        return quotationStatusId;
    }

    public static class Builder extends Quotation.Builder {

        private String quotationStatusId;

        public Builder quotationStatusId(String quotationStatusId) {
            this.quotationStatusId = quotationStatusId;
            return this;
        }

        @Override
        public Quotation build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "QuotationStatus{" +
                "quotationStatusId='" + quotationStatusId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuotationStatus quotationStatus = (QuotationStatus) o;
        return quotationStatusId.equals(quotationStatus.quotationStatusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quotationStatusId);
    }
}

