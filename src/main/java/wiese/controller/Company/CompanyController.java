package wiese.controller.Company;

import wiese.domains.Company.Company;
import wiese.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    @Qualifier("CompanyServiceImpl")
    private CompanyServiceImpl companyService;

    @PostMapping("/create")
    public Company create(@RequestBody Company company){
        return companyService.create(company);
    }

    @PostMapping("/update")
    public Company company(@RequestBody Company company){
        return companyService.update(company);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id){
        companyService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Company read(@PathVariable int id){
        return companyService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public Set<Company> getAll(){
        return companyService.getAll();
    }

}
