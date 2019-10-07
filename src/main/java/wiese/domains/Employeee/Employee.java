package wiese.domains.Employeee;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Employee {

    @Id
    private String employeeId, firstName, lastName, address;
    @OneToMany()
    private String desc;

    public Employee() {
    }

    public Employee(Builder builder) {
        this.employeeId = builder.employeeId;
        this.address=builder.address;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.desc = builder.desc;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                "firstName='" + firstName + '\'' +
                "employeeId='" + employeeId + '\'' +
                "lastName='" + lastName + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String employeeId,firstName,lastName,address, desc;

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Employee employee){
            this.employeeId = employee.employeeId;
            this.address = employee.address;
            this.lastName=employee.lastName;
            this.firstName=employee.firstName;
            this.desc = employee.desc;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}

