package wiese.domains.Supplier;

import java.util.Objects;

public class SupplierLeadTime {

    private String leadTimeId;

    public SupplierLeadTime() {
    }

    public SupplierLeadTime(Builder builder) {
        this.leadTimeId = builder.leadTimeId;
    }

    public String getLeadTimeId() {
        return leadTimeId;
    }

    public void setLeadTimeId(String leadTimeId) {
        this.leadTimeId = leadTimeId;
    }

    public static class Builder {

        private String leadTimeId;

        public Builder leadTimeId(String leadTimeId) {
            this.leadTimeId = leadTimeId;
            return this;
        }

        public SupplierLeadTime build() {
            return new SupplierLeadTime(this);
        }
    }

    @Override
    public String toString() {
        return "SupplierLeadTime{" +
                "leadTimeId='" + leadTimeId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierLeadTime supplierLeadTime = (SupplierLeadTime) o;
        return leadTimeId.equals(supplierLeadTime.leadTimeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leadTimeId);
    }
}

