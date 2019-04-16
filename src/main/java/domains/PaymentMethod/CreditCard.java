package domains.PaymentMethod;

public class CreditCard extends PaymentMethod {

    private String savings;

    public CreditCard(){}

    public CreditCard(Builder builder){
        super(builder);
        this.savings=builder.savings;
    }

    public String getSavings(){
        return savings;
    }

    public static class Builder extends PaymentMethod.Builder{

        private String savings;

        public Builder savings(String savings){
            this.savings=savings;
            return this;
        }

        @Override
        public PaymentMethod build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "savings='" +savings + '\'' +
                '}';
    }
}
