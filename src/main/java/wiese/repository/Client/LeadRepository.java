package wiese.repository.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Client.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, String> {

}
