package wiese.factory;

import wiese.factories.Employee.EmployeeFactory;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Employeee.Employee;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee(){

        String address = "West Beach";
        String firstName = "AJ";
        String lastName = "Wiese";

        Employee emp = EmployeeFactory.getEmployee(firstName,lastName,address);
        System.out.println(emp);
        Assert.assertNotNull(emp.getEmployeeId());
    }
}
