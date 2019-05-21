package wiese.repository.Employee;

import wiese.domains.Employeee.Employee;
import wiese.repository.Repository;

import java.util.Set;

public interface EmployeeRepository extends Repository <Employee, Integer> {
    Set<Employee> getAll();
}
