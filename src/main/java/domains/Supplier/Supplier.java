package domains.Supplier;

public class Supplier {

    private String supplierName, supplierAddress;

    public Supplier(){}

    public Supplier(Builder builder){
        this.supplierName = builder.supplierName;
        this.supplierAddress = builder.supplierAddress;
    }

    public String getSupplierName(){return supplierName;}

    public String getSupplierAddress(){return supplierAddress;}

    public static class Builder{

        private String supplierName, supplierAddress;

        public Builder supplierName(String supplierName){
            this.supplierName=supplierName;
            return this;
        }

        public Builder supplierAddress(String supplierAddress){
            this.supplierAddress=supplierAddress;
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }


        @Override
        public String toString() {
            return "Supplier{" +
                    "supplierName='" + supplierName + '\'' +
                    ", supplierAddress='" + supplierAddress + '\'' +
                    '}';
        }
    }
}
