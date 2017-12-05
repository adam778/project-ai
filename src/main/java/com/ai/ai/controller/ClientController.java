package com.ai.ai.controller;

import com.ai.ai.dto.ClientDto;
import com.ai.ai.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    List<ClientDto> getAll(){
        return clientService.findAll();
    }

}
