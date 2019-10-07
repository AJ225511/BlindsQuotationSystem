package wiese.domains.PaymentMethod;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class PaymentMethod {
    
    @Id
    private String paymentMethodId, paymentDate;
    @OneToMany()
    private String desc;

    public PaymentMethod() {
    }

    public PaymentMethod(Builder builder) {
        this.paymentMethodId = builder.paymentMethodId;
        this.paymentDate = builder.paymentDate;
        this.desc = builder.desc;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getPaymentDate(){
        return paymentDate;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentMethodId='" + paymentMethodId + '\'' +
                "paymentDate='" + paymentDate + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String paymentMethodId,paymentDate, desc;

        public Builder paymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return this;
        }

        public Builder paymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(PaymentMethod paymentMethod){
            this.paymentMethodId = paymentMethod.paymentMethodId;
            this.paymentDate = paymentMethod.paymentDate;
            this.desc = paymentMethod.desc;
            return this;
        }

        public PaymentMethod build() {
            return new PaymentMethod(this);
        }
    }

}

