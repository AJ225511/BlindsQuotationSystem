package wiese.factory.Employee;

import org.junit.Before;
import wiese.factories.Employee.EmployeeFactory;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Employeee.Employee;

public class EmployeeFactoryTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getEmployee() {

        Employee emp = EmployeeFactory.getEmployee("AJ", "Wiese", "12 Bratton Way");
        Assert.assertNotNull(emp.getEmployeeId());
        System.out.println(emp.getFirstName());
    }
}
