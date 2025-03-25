package exp.my.n_p_1.controller;

import exp.my.n_p_1.entity.Client;
import exp.my.n_p_1.repository.ClientRepository;
import exp.my.n_p_1.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fillDb")
    public String fillDataBase() {
        clientService.generateDB();
        return "Amount clients: " + clientRepository.count();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Client> findByNameContaining(@RequestParam String clientName) {
        return clientService.findByNameContaining(clientName);
    }
}
