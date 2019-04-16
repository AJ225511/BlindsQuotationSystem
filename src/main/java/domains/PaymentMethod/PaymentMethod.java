package domains.PaymentMethod;

public class PaymentMethod {

    private String paymentId,paymentDate, paymentAmount;

    public PaymentMethod(){}

    public PaymentMethod(Builder builder){
        this.paymentAmount= builder.paymentAmount;
        this.paymentDate= builder.paymentDate;
        this.paymentId= builder.paymentId;
    }

    public String getPaymentId(){
        return paymentId;
    }

    public String getPaymentDate(){
        return paymentDate;
    }

    public String getPaymentAmount() { return paymentAmount;}

    public static class Builder{

        private String paymentId, paymentDate, paymentAmount;

        public Builder paymentId(String paymentId){
            this.paymentId=paymentId;
            return this;
        }

        public Builder paymentDate(String paymentDate){
            this.paymentDate=paymentDate;
            return this;
        }

        public Builder paymentAmount(String paymentAmount){
            this.paymentAmount=paymentAmount;
            return this;
        }

        public PaymentMethod build(){
            return new PaymentMethod(this);
        }

    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentId='" + paymentId + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", paymentAmount='" + paymentAmount + '\'' +
                '}';
    }
}
