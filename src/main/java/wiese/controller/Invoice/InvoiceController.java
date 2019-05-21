package wiese.controller.Invoice;

import wiese.domains.Invoice.Invoice;
import wiese.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    @Qualifier("InvoiceServiceImpl")
    private InvoiceServiceImpl invoiceService;

    @PostMapping("/create")
    public Invoice create(@RequestBody Invoice invoice){
        return invoiceService.create(invoice);
    }

    @PostMapping("/update")
    public Invoice invoice(@RequestBody Invoice invoice){
        return invoiceService.update(invoice);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id){
        invoiceService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Invoice read(@PathVariable int id){
        return invoiceService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public Set<Invoice> getAll(){
        return invoiceService.getAll();
    }

}
