package wiese.domains.Supplier;

import java.util.Objects;

public class Supplier {

    private String supplierId, supplierName, supplierAddress;

    public Supplier() {
    }

    public Supplier(Builder builder) {
        this.supplierName = builder.supplierName;
        this.supplierAddress = builder.supplierAddress;
        this.supplierId = builder.supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public static class Builder {

        private String supplierName, supplierAddress, supplierId;

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder supplierAddress(String supplierAddress) {
            this.supplierAddress = supplierAddress;
            return this;
        }

        public Builder supplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }


        @Override
        public String toString() {
            return "Supplier{" +
                    "supplierName='" + supplierName + '\'' +
                    ", supplierAddress='" + supplierAddress + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Supplier supplier = (Supplier) o;
            return supplierId.equals(supplier.supplierId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(supplierId);
        }
    }

}
