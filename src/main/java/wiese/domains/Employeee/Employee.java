package wiese.domains.Employeee;

import java.util.Objects;

public class Employee {

    private String employeeId, firstName, lastName, address;

    public Employee(){}

    public Employee(Builder builder){
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId=employeeId;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public static class Builder{

        private String employeeId, firstName, lastName, address;

        public Builder employeeId(String employeeId){
            this.employeeId=employeeId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }

        public Builder address(String address){
            this.address=address;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }

        @Override
        public String toString(){
            return "Employee{"+
                    "employeeId: '"+ employeeId + '\''+
                    ", firstName: '" + firstName +'\'' +
                    ", lastName: '" + lastName +'\'' +
                    ", address: '" + address +'\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return employeeId.equals(employee.employeeId);
        }

        @Override
        public int hashCode(){
            return Objects.hash(employeeId);
        }
    }
}

