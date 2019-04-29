package repository.impl;

import domains.Employeee.Employee;
import repository.Employee.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl(){
        this.employees = new HashSet<>();
    }

    public static EmployeeRepositoryImpl getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee find(String id){
        return employees.stream().filter(employee -> employee.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public Set<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee employee1 = find(employee.getEmployeeId());
        if(employees.contains(employee1)){
            employees.remove(employee1);
            employees.add(employee);
        }
        return employee1;
    }

    @Override
    public void delete(Integer id) {

        Employee employee = find(Integer.toString(id));
        employees.remove(employee);

    }

    @Override
    public Employee read(Integer id) {
        Employee employee = find(Integer.toString(id));
        if(employee == null){
            return null;
        }
        else{
            return employee;
        }
    }
}
