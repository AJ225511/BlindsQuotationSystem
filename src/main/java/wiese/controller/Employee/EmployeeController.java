package wiese.controller.Employee;

import wiese.domains.Employeee.Employee;
import wiese.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    @Qualifier("EmployeeServiceImpl")
    private EmployeeServiceImpl employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PostMapping("/update")
    public Employee employee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Employee read(@PathVariable String id) {
        return employeeService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

}
