package wiese.domains.Client;

import java.util.Objects;

public class Referral extends Lead {

    private String referralId;

    public Referral() {
    }

    public Referral(Builder builder) {
        super(builder);
        this.referralId = builder.referralId;
    }

    public String getReferralId() {
        return referralId;
    }

    public static class Builder extends Lead.Builder {

        private String referralId;

        public Builder referralId(String referralId) {
            this.referralId = referralId;
            return this;
        }

        @Override
        public Lead build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Referral{" +
                "referralId='" + referralId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Referral referral = (Referral) o;
        return referralId.equals(referral.referralId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referralId);
    }
}

