package factories.Employee;

import domains.Employeee.Employee;
import util.Misc;

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
