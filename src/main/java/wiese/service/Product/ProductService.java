package wiese.service.Product;

import wiese.domains.Product.Product;
import wiese.service.Service;

import java.util.Set;

public interface ProductService extends Service<Product, Integer> {
    Set<Product> getAll();
}
