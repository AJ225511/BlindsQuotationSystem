package wiese.domains.PaymentMethod;

import java.util.Objects;

public class PaymentMethod {

    private String paymentId, paymentDate;
    private int paymentAmount;

    public PaymentMethod() {
    }

    public PaymentMethod(Builder builder) {
        this.paymentAmount = builder.paymentAmount;
        this.paymentDate = builder.paymentDate;
        this.paymentId = builder.paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public static class Builder {

        private String paymentId, paymentDate;
        private int paymentAmount;

        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder paymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder paymentAmount(int paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public PaymentMethod build() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethod paymentMethod = (PaymentMethod) o;
        return paymentId.equals(paymentMethod.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }
}

