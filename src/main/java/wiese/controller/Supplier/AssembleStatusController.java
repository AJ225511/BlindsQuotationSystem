package wiese.controller.Supplier;

import wiese.domains.Supplier.AssembleStatus;
import wiese.service.impl.AssembleStatusServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/assembleStatus")
public class AssembleStatusController {

    @Autowired
    @Qualifier("AssembleStatusServiceImpl")
    private AssembleStatusServiceImpl assembleStatusService;

    @PostMapping("/create")
    public AssembleStatus create(@RequestBody AssembleStatus assembleStatus) {
        return assembleStatusService.create(assembleStatus);
    }

    @PostMapping("/update")
    public AssembleStatus assembleStatus(@RequestBody AssembleStatus assembleStatus) {
        return assembleStatusService.update(assembleStatus);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        assembleStatusService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public AssembleStatus read(@PathVariable String id) {
        return assembleStatusService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public List<AssembleStatus> getAll() {
        return assembleStatusService.getAll();
    }

}
