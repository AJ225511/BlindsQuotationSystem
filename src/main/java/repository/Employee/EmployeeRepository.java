package repository.Employee;

import domains.Employeee.Employee;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface EmployeeRepository extends Repository <Employee, Integer> {
    Set<Employee> getAll();
}
