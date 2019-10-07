package wiese.repository.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Employeee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
