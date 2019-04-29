package service.Product;

import domains.Product.Product;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface ProductService extends Service<Product, Integer> {
    Set<Product> getAll();
}
