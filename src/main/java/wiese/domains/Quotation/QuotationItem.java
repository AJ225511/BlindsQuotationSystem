package wiese.domains.Quotation;

import java.util.Objects;

public class QuotationItem extends Quotation {

    private String quotationItemId;

    public QuotationItem() {
    }

    public QuotationItem(Builder builder) {
        super(builder);
        this.quotationItemId = builder.quotationItemId;
    }

    public String getQuotationItemId() {
        return quotationItemId;
    }

    public static class Builder extends Quotation.Builder {

        private String quotationItemId;

        public Builder quotationItemId(String quotationItemId) {
            this.quotationItemId = quotationItemId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuotationItem quotationItem = (QuotationItem) o;
        return quotationItemId.equals(quotationItem.quotationItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quotationItemId);
    }
}

