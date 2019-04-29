package repository.Product;

import domains.Product.Product;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface ProductRepository extends Repository <Product, Integer> {
    Set<Product> getAll();
}
