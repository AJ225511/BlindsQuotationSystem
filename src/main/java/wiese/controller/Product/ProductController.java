package wiese.controller.Product;

import wiese.domains.Product.Product;
import wiese.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("ProductServiceImpl")
    private ProductServiceImpl productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PostMapping("/update")
    public Product product(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Product read(@PathVariable int id) {
        return productService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public Set<Product> getAll() {
        return productService.getAll();
    }

}
