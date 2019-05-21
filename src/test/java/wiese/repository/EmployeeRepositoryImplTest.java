package wiese.repository;

import wiese.domains.Employeee.Employee;
import wiese.factories.Employee.EmployeeFactory;
import wiese.repository.impl.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class EmployeeRepositoryImplTest {

    @Autowired
    private EmployeeRepositoryImpl employeeRepository;
    private String clientId = null;

    @Test
    public void create(){

        Employee employee = EmployeeFactory.getEmployee("AJ", "Wiese", "West Beach");
        employeeRepository.create(employee);

        Assert.assertNotNull(employeeRepository.getAll());
    }

    @Test
    public void read(){
        try {
            Employee employee = EmployeeFactory.getEmployee("AJ", "Wiese", "West Beach");
            employeeRepository.create(employee);

            Assert.assertNotNull(employeeRepository.getAll());
            System.out.println(employee);

            Employee employee1 = employeeRepository.read(Integer.parseInt(employee.getEmployeeId()));
            Assert.assertEquals(employee, employee1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update(){

        Employee employee = EmployeeFactory.getEmployee("AJ", "Wiese", "West Beach");
        employeeRepository.create(employee);

        Assert.assertNotNull(employeeRepository.getAll());
        Employee employee1 = EmployeeFactory.getEmployee("JJ", "Wiese", "Parklands");
        employee1.setEmployeeId(employee.getEmployeeId());
        employeeRepository.update(employee1);

        Employee updatedEmployee = employeeRepository.find(employee1.getEmployeeId());
        Assert.assertEquals(employee1, updatedEmployee);

        System.out.println(updatedEmployee);

    }

    @Test
    public void delete(){
        try {
            Employee employee = EmployeeFactory.getEmployee("AJ", "Wiese", "West Beach");
            employeeRepository.create(employee);

            Assert.assertNotNull(employeeRepository.getAll());
            employeeRepository.delete(Integer.parseInt(employee.getEmployeeId()));
            Employee deleted = employeeRepository.find(employee.getEmployeeId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }


    }
}
