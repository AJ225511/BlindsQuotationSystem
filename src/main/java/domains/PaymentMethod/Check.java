package domains.PaymentMethod;

public class Check extends PaymentMethod {

    private String checkId;

    public Check(){}

    public Check(Builder builder){
        super(builder);
        this.checkId=builder.checkId;
    }

    public String getCheckId(){
        return checkId;
    }

    public static class Builder extends PaymentMethod.Builder{

        private String checkId;

        public Builder checkId(String checkId){
            this.checkId=checkId;
            return this;
        }

        @Override
        public PaymentMethod build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Check{" +
                "checkId='" +checkId + '\'' +
                '}';
    }
}
