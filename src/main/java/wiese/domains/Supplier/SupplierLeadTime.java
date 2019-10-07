package wiese.domains.Supplier;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class SupplierLeadTime {

    @Id
    private String leadTimeId;
    @OneToMany()
    private String desc;

    public SupplierLeadTime() {
    }

    public SupplierLeadTime(Builder builder) {
        this.leadTimeId = builder.leadTimeId;
        this.desc = builder.desc;
    }

    public String getSupplierLeadTimeId() {
        return leadTimeId;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "SupplierLeadTime{" +
                "leadTimeId='" + leadTimeId + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String leadTimeId, desc;

        public Builder leadTimeId(String leadTimeId) {
            this.leadTimeId = leadTimeId;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(SupplierLeadTime leadTime){
            this.leadTimeId = leadTime.leadTimeId;
            this.desc = leadTime.desc;
            return this;
        }

        public SupplierLeadTime build() {
            return new SupplierLeadTime(this);
        }
    }

}

