package wiese.service.Product;

import wiese.domains.Product.Product;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface ProductService extends Service<Product, String> {
    Product retrieveByDesc(String productDesc);
    List<Product> getAll();
}
