package wiese.domains.PaymentMethod;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return checkId.equals(check.checkId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(checkId);
    }
}

