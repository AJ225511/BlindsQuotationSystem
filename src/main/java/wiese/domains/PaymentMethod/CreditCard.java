package wiese.domains.PaymentMethod;

import javax.persistence.Id;
import javax.persistence.OneToMany;

public class CreditCard extends PaymentMethod {

    @Id
    private String savings;
    @OneToMany()
    private String desc;

    public CreditCard() {
    }

    public CreditCard(Builder builder) {
        this.savings = builder.savings;
        this.desc = builder.desc;
    }

    public String getCreditCardId() {
        return savings;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "savings='" + savings + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String savings, desc;

        public Builder savings(String savingsId) {
            this.savings = savings;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(CreditCard savings){
            this.savings = savings.savings;
            this.desc = savings.desc;
            return this;
        }

        public CreditCard build() {
            return new CreditCard(this);
        }
    }

}
