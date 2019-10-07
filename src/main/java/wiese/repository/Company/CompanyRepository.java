package wiese.repository.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}
