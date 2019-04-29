package service.impl;

import domains.Employeee.Employee;
import repository.Employee.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.Employee.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeServiceImpl service = null;
    private EmployeeRepository repository;
    private Integer id;

    public EmployeeServiceImpl(){
        repository = EmployeeRepositoryImpl.getRepository();
    }

    public EmployeeService getService(){
        if(service == null) service = new EmployeeServiceImpl();
        return service;
    }

    @Override
    public Set<Employee> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Employee read(Integer integer) {
        return this.repository.read(id);
    }
}
