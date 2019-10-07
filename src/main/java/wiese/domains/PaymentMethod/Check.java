package wiese.domains.PaymentMethod;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Check extends PaymentMethod {

    @Id
    private String checkId;
    @OneToMany()
    private String desc;

    public Check() {
    }

    public Check(Builder builder) {
        this.checkId = builder.checkId;
        this.desc = builder.desc;
    }

    public String getCheckId() {
        return checkId;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Check{" +
                "checkId='" + checkId + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String checkId, desc;

        public Builder checkId(String checkId) {
            this.checkId = checkId;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Check check){
            this.checkId = check.checkId;
            this.desc = check.desc;
            return this;
        }

        public Check build() {
            return new Check(this);
        }
    }

}

