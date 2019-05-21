package wiese.domains.PaymentMethod;

public class Cash extends PaymentMethod {

    private int cashAmount;

    public Cash(){}

    public Cash(Builder builder){
        super(builder);
        this.cashAmount=builder.cashAmount;
    }

    public int getCashAmount(){
        return cashAmount;
    }

    public static class Builder extends PaymentMethod.Builder{

        private int cashAmount;

        public Builder cashAmount(int cashAmount){
            this.cashAmount=cashAmount;
            return this;
        }

        @Override
        public PaymentMethod build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Cash{" +
                "cashAmount='" +cashAmount + '\'' +
                '}';
    }
}
