package service.impl;

import domains.Product.Product;
import repository.Product.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.Product.ProductService;

import java.util.Set;

public class ProductServiceImpl implements  ProductService{

    private ProductServiceImpl service = null;
    private ProductRepository repository;
    private Integer id;

    public ProductServiceImpl(){
        repository = ProductRepositoryImpl.getRepository();
    }

    public ProductService getService(){
        if(service == null) service = new ProductServiceImpl();
        return service;
    }

    @Override
    public Set<Product> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Product create(Product product) {
        return this.repository.create(product);
    }

    @Override
    public Product update(Product product) {
        return this.repository.update(product);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Product read(Integer integer) {
        return this.repository.read(id);
    }
}

