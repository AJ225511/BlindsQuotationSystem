package wiese.service.Employee;

import wiese.domains.Employeee.Employee;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface EmployeeService extends Service<Employee, String> {
    Employee retrieveByDesc(String employeeDesc);
    List<Employee> getAll();
}