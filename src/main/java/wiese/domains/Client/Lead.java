package wiese.domains.Client;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Lead {

    @Id
    private String leadId, leadDate;
    @OneToMany()
    private String desc;

    public Lead() {
    }

    public Lead(Builder builder) {
        this.leadId = builder.leadId;
        this.leadDate=builder.leadDate;
        this.desc = builder.desc;
    }

    public String getLeadId() {
        return leadId;
    }

    public String getLeadDate() {
        return leadDate;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "leadId='" + leadId + '\'' +
                "leadDate='" + leadDate + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String leadId,leadDate, desc;

        public Builder leadId(String leadId) {
            this.leadId = leadId;
            return this;
        }

        public Builder leadDate(String leadDate) {
            this.leadDate = leadDate;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Lead lead){
            this.leadId = lead.leadId;
            this.leadDate=lead.leadDate;
            this.desc = lead.desc;
            return this;
        }

        public Lead build() {
            return new Lead(this);
        }
    }

}

