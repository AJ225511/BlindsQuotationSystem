package wiese.controller.Supplier;

import wiese.domains.Supplier.Supplier;
import wiese.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    @Qualifier("SupplierServiceImpl")
    private SupplierServiceImpl supplierService;

    @PostMapping("/create")
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.create(supplier);
    }

    @PostMapping("/update")
    public Supplier supplier(@RequestBody Supplier supplier) {
        return supplierService.update(supplier);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        supplierService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Supplier read(@PathVariable String id) {
        return supplierService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }

}
