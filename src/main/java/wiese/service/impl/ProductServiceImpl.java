package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.domains.Product.Product;
import wiese.repository.Product.ProductRepository;
import wiese.service.Product.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl assembleStatusService = null;
    @Autowired
    private ProductRepository assembleStatusRepository;

    private ProductServiceImpl() {

    }

    public static ProductService getProductService() {
        if (assembleStatusService == null) assembleStatusService = new ProductServiceImpl();
        return assembleStatusService;
    }

    @Override
    public Product create(Product assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public Product read(String s){
        Optional<Product> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public Product update(Product assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public Product retrieveByDesc(String assembleDesc){
        List<Product> assembleStatuses = getAll();
        for(Product assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<Product> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}

