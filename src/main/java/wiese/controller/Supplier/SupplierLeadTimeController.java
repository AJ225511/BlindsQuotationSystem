package wiese.controller.Supplier;

import wiese.domains.Supplier.SupplierLeadTime;
import wiese.service.impl.SupplierLeadTimeServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/supplierLeadTime")
public class SupplierLeadTimeController {

    @Autowired
    @Qualifier("SupplierLeadTimeServiceImpl")
    private SupplierLeadTimeServiceImpl supplierLeadTimeService;

    @PostMapping("/create")
    public SupplierLeadTime create(@RequestBody SupplierLeadTime supplierLeadTime) {
        return supplierLeadTimeService.create(supplierLeadTime);
    }

    @PostMapping("/update")
    public SupplierLeadTime supplierLeadTime(@RequestBody SupplierLeadTime supplierLeadTime) {
        return supplierLeadTimeService.update(supplierLeadTime);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        supplierLeadTimeService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public SupplierLeadTime read(@PathVariable String id) {
        return supplierLeadTimeService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public List<SupplierLeadTime> getAll() {
        return supplierLeadTimeService.getAll();
    }

}
