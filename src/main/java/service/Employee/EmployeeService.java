package service.Employee;

import domains.Employeee.Employee;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface EmployeeService extends Service<Employee, Integer> {
    Set<Employee> getAll();
}