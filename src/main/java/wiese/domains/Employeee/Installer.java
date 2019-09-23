package wiese.domains.Employeee;

public class Installer extends Employee {

    private String installDate;

    public Installer() {
    }

    public Installer(Builder builder) {
        super(builder);
        this.installDate = builder.installDate;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public static class Builder extends Employee.Builder {

        private String installDate;

        public Builder() {
            super();
        }

        public Builder installDate(String installDate) {
            this.installDate = installDate;
            return this;
        }

        @Override
        public Employee build() {
            return new Installer(this);
        }

        @Override
        public String toString() {
            return "Installer{" +
                    "installDate='" + installDate + '\'' +
                    '}';
        }

    }
}
