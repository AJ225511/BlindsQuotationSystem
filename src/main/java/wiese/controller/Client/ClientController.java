package wiese.controller.Client;

import wiese.domains.Client.Client;
import wiese.service.impl.ClientServiceImpl;
import wiese.service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/blinds/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @PostMapping("/update")
    public Client client(@RequestBody Client client) {
        return clientService.update(client);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }

    @GetMapping("/read/{id}")
    public Client read(@PathVariable String id) {
        return clientService.read(id);
    }

    @GetMapping("read/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }

}
