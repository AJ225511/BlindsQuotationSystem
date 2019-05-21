package wiese.controller.Client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import wiese.domains.Client.Client;
import wiese.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    @Qualifier("ClientServiceImpl")
    private ClientServiceImpl clientService;

    @PostMapping("/create")
    public Client create(@RequestBody Client client){
        return clientService.create(client);
    }

    @PostMapping("/update")
    public Client client(@RequestBody Client client){
        return clientService.update(client);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id){
        clientService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Client read(@PathVariable int id){
        return clientService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public Set<Client> getAll(){
        return clientService.getAll();
    }

}
