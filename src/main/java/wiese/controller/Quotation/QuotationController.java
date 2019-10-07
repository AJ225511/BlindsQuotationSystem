package wiese.controller.Quotation;

import wiese.domains.Quotation.Quotation;
import wiese.service.impl.QuotationServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/quotation")
public class QuotationController {

    @Autowired
    @Qualifier("QuotationServiceImpl")
    private QuotationServiceImpl quotationService;

    @PostMapping("/create")
    public Quotation create(@RequestBody Quotation quotation) {
        return quotationService.create(quotation);
    }

    @PostMapping("/update")
    public Quotation quotation(@RequestBody Quotation quotation) {
        return quotationService.update(quotation);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        quotationService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Quotation read(@PathVariable String id) {
        return quotationService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public List<Quotation> getAll() {
        return quotationService.getAll();
    }

}
