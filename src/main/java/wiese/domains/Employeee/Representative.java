package wiese.domains.Employeee;

import java.util.Objects;

public class Representative extends Employee {

    private String representativeId;

    public Representative() {
    }

    public Representative(Builder builder) {
        super(builder);
        this.representativeId = builder.representativeId;
    }

    public String getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(String representativeId) {
        this.representativeId = representativeId;
    }

    public static class Builder extends Employee.Builder {

        private String representativeId;

        public Builder() {
            super();
        }

        public Builder representativeId(String representativeId) {
            this.representativeId = representativeId;
            return this;
        }

        @Override
        public Employee build() {
            return new Representative(this);
        }

        @Override
        public String toString() {
            return "Representative{" +
                    "representativeId='" + representativeId + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Representative representative = (Representative) o;
            return representativeId.equals(representative.representativeId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(representativeId);
        }
    }

}
