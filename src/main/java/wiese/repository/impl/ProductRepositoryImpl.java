//package wiese.repository.impl;
//
//import org.springframework.stereotype.Repository;
//import wiese.domains.Product.Product;
//import wiese.repository.Product.ProductRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("ProductInMemory")
//public class ProductRepositoryImpl implements ProductRepository {
//
//    private static ProductRepositoryImpl repository = null;
//    private Set<Product> products;
//
//    private ProductRepositoryImpl() {
//        this.products = new HashSet<>();
//    }
//
//    public static ProductRepositoryImpl getRepository() {
//        if (repository == null) repository = new ProductRepositoryImpl();
//        return repository;
//    }
//
//    public Product find(String id) {
//        return products.stream().filter(product -> product.getProductId() == id).findAny().orElse(null);
//    }
//
//    @Override
//    public Set<Product> getAll() {
//        return products;
//    }
//
//    @Override
//    public Product create(Product product) {
//        this.products.add(product);
//        return product;
//    }
//
//    @Override
//    public Product update(Product product) {
//        Product product1 = find(product.getProductId());
//        if (products.contains(product1)) {
//            products.remove(product1);
//            products.add(product);
//        }
//        return product1;
//    }
//
//    @Override
//    public void delete(Integer id) {
//
//        Product product = find(Integer.toString(id));
//        products.remove(product);
//
//    }
//
//    @Override
//    public Product read(Integer id) {
//        Product product = find(Integer.toString(id));
//        if (product == null) {
//            return null;
//        } else {
//            return product;
//        }
//    }
//}

