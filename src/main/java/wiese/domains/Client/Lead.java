package wiese.domains.Client;

import java.util.Objects;

public class Lead {

    private String leadId, leadDate;

    public Lead() {
    }

    public Lead(Builder builder) {
        this.leadDate = builder.leadDate;
        this.leadId = builder.leadId;
    }

    public String getLeadId() {
        return leadId;
    }

    public String getLeadDate() {
        return leadDate;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public static class Builder {

        private String leadId, leadDate;

        public Builder leadId(String leadId) {
            this.leadId = leadId;
            return this;
        }

        public Builder leadDate(String leadDate) {
            this.leadDate = leadDate;
            return this;
        }

        public Lead build() {
            return new Lead(this);
        }
    }

    @Override
    public String toString() {
        return "Lead{" +
                "leadId='" + leadId + '\'' +
                ", leadDate='" + leadDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return leadId.equals(lead.leadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leadId);
    }
}

