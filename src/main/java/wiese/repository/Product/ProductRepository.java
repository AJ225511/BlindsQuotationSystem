package wiese.repository.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
