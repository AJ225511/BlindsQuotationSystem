package wiese.domains.Employeee;

public class Domestic extends Employee{

    private String daysOnDuty;

    public Domestic(){}

    public Domestic(Builder builder){
        super(builder);
        this.daysOnDuty= builder.daysOnDuty;
    }

    public String getDaysOnDuty(){
        return daysOnDuty;
    }

    public void setDaysOnDuty(String daysOnDuty){
        this.daysOnDuty=daysOnDuty;
    }

    public static class Builder extends Employee.Builder{

        private String daysOnDuty;

        public Builder(){
            super();
        }

        public Builder daysOnDuty(String daysOnDuty){
            this.daysOnDuty=daysOnDuty;
            return this;
        }
        @Override
        public Employee build(){
            return new Domestic(this);
        }

        @Override
        public String toString() {
            return "Domestic{" +
                    "daysOnDuty='" + daysOnDuty + '\'' +
                    '}';
        }

    }
}
