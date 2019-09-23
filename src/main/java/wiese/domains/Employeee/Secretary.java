package wiese.domains.Employeee;

public class Secretary extends Employee {

    private String type;

    public Secretary() {
    }

    public Secretary(Builder builder) {
        super(builder);
        this.type = builder.type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Builder extends Employee.Builder {

        private String type;

        public Builder() {
            super();
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public Employee build() {
            return new Secretary(this);
        }

        @Override
        public String toString() {
            return "Secretary{" +
                    "type='" + type + '\'' +
                    '}';
        }

    }
}
