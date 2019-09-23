package wiese.repository.Product;

import wiese.domains.Product.Product;
import wiese.repository.Repository;

import java.util.Set;

public interface ProductRepository extends Repository<Product, Integer> {
    Set<Product> getAll();
}
