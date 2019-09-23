package wiese.service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Employeee.Employee;
import wiese.factories.Employee.EmployeeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.EmployeeServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Test
    public void create() {
        Employee employee = EmployeeFactory.getEmployee("AJ", "Wiese", "4 Bratton Way");
        employeeService.create(employee);

        assertNotNull(employeeService.getAll());
        System.out.println(employee.getFirstName());
    }

    @Test
    public void read() {
        try {
            Employee employee = EmployeeFactory.getEmployee("AJ", "Wiese", "4 Bratton Way");
            employeeService.create(employee);

            Employee employee1 = employeeService.read(Integer.parseInt(employee.getEmployeeId()));
            assertEquals(employee, employee1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            Employee employee = EmployeeFactory.getEmployee("AJ", "Wiese", "4 Bratton Way");
            employeeService.create(employee);

            Employee employee1 = EmployeeFactory.getEmployee("JJ", "Wiese", "9 Bratton Way");
            employee1.setEmployeeId(employee.getEmployeeId());
            employeeService.update(employee1);
            System.out.println("Original: \n" + employee.getFirstName());
            System.out.println("Updated: \n" + employee1.getFirstName());

            Employee employee2 = employeeService.read(Integer.parseInt(employee1.getEmployeeId()));
            assertEquals(employee1, employee2);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }

    @Test
    public void delete() {
        try {
            Employee employee = EmployeeFactory.getEmployee("Erik", "Wiese", "11 Bratton Way");
            employeeService.create(employee);

            assertNotNull(employeeService.getAll());
            Employee employee1 = employeeService.read(Integer.parseInt(employee.getEmployeeId()));
            assertNull(employee1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }
}

