package wiese.domains.Client;

public class Existing extends Lead {

    private String joinDate;

    public Existing() {
    }

    public Existing(Builder builder) {
        super(builder);
        this.joinDate = builder.joinDate;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public static class Builder extends Lead.Builder {

        private String joinDate;

        public Builder joinDate(String joinDate) {
            this.joinDate = joinDate;
            return this;
        }

        @Override
        public Lead build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Existing{" +
                "joinDate='" + joinDate + '\'' +
                '}';
    }

}

