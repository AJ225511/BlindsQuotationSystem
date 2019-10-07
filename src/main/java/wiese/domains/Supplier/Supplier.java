package wiese.domains.Supplier;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Supplier {

    @Id
    private String supplierId, supplierName, supplierAddress;
    @OneToMany()
    private String desc;

    public Supplier() {
    }

    public Supplier(Builder builder) {
        this.supplierId = builder.supplierId;
        this.desc = builder.desc;
        this.supplierAddress = builder.supplierAddress;
        this.supplierName = builder.supplierName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName(){
        return supplierName;
    }

    public String getSupplierAddress(){
        return supplierAddress;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                "supplierName='" + supplierName + '\'' +
                "supplierAddress='" + supplierAddress + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String supplierId,supplierName, supplierAddress, desc;

        public Builder supplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder supplierAddress(String supplierAddress) {
            this.supplierAddress = supplierAddress;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Supplier supplier){
            this.supplierId = supplier.supplierId;
            this.desc = supplier.desc;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }

}
