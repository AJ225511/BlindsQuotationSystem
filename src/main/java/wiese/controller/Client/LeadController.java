package wiese.controller.Client;

import wiese.domains.Client.Lead;
import wiese.service.impl.LeadServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/lead")
public class LeadController {
    @Autowired
    @Qualifier("LeadServiceImpl")
    private LeadServiceImpl leadService;

    @PostMapping("/create")
    public Lead create(@RequestBody Lead lead) {
        return leadService.create(lead);
    }

    @PostMapping("/update")
    public Lead lead(@RequestBody Lead lead) {
        return leadService.update(lead);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        leadService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Lead read(@PathVariable String id) {
        return leadService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public List<Lead> getAll() {
        return leadService.getAll();
    }

}
