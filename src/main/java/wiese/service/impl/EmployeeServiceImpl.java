package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.domains.Employeee.Employee;
import wiese.repository.Employee.EmployeeRepository;
import wiese.service.Employee.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl assembleStatusService = null;
    @Autowired
    private EmployeeRepository assembleStatusRepository;

    private EmployeeServiceImpl() {

    }

    public static EmployeeService getEmployeeService() {
        if (assembleStatusService == null) assembleStatusService = new EmployeeServiceImpl();
        return assembleStatusService;
    }

    @Override
    public Employee create(Employee assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public Employee read(String s){
        Optional<Employee> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public Employee update(Employee assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public Employee retrieveByDesc(String assembleDesc){
        List<Employee> assembleStatuses = getAll();
        for(Employee assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<Employee> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}
