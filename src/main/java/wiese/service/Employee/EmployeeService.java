package wiese.service.Employee;

import wiese.domains.Employeee.Employee;
import wiese.service.Service;

import java.util.Set;

public interface EmployeeService extends Service<Employee, Integer> {
    Set<Employee> getAll();
}