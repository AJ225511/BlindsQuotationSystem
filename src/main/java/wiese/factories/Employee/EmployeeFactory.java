package wiese.factories.Employee;

import wiese.domains.Employeee.Employee;
import wiese.util.Misc;

public class EmployeeFactory {

    public static Employee getEmployee(String firstName, String lastName, String address){
        return new Employee.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .employeeId(Misc.generateId())
                .build();
    }
}
