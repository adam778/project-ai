package com.ai.ai.controller;

import com.ai.ai.dto.ClientDto;
import com.ai.ai.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<ClientDto> getAll() {
        return clientService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ClientDto getOne(@PathVariable(name = "id") Long clientId) {
        return clientService.findOne(clientId);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    void deleteAll() {
        clientService.deleteAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteOne(@PathVariable(name = "id") Long clientId) {
        clientService.deleteOne(clientId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    void updateOne(@PathVariable(value = "id") Long clientId, @RequestBody ClientDto client) {
        ClientDto currentClient = clientService.findOne(clientId);
        currentClient.setAdress(client.getAdress());
        currentClient.setCompanyName(client.getCompanyName());
        currentClient.setEmail(client.getEmail());
        currentClient.setName(client.getName());
        currentClient.setPhone(client.getPhone());
        currentClient.setSurname(client.getSurname());

        clientService.save(currentClient);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    void insertOne(@RequestBody ClientDto clientDto) {
        clientService.insert(clientDto);
    }

}
