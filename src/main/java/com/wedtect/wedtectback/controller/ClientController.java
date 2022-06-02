package com.wedtect.wedtectback.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.wedtect.wedtectback.entities.Client;
import com.wedtect.wedtectback.service.IClientService;

@RestController
public class ClientController {
    @Autowired
    IClientService iClientService;
    @GetMapping(value = "/clients")
    public List<Client> findAllClients(){
        return iClientService.findAll();
    }
    @GetMapping(value = "/clients/{id}")
    public Client findoneClient(@PathVariable Long id)
    {
        return iClientService.findClient(id);
    }
    @PostMapping(value = "/clients")
    public Client addClient(@RequestBody Client C)
    {
        return iClientService.addClient(C);
    }
    @PutMapping(value="/clients/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client C)
    {
        C.setId(id);
        return iClientService.updateClient(C);
    }
    @DeleteMapping(value="/clients/{id}")
    public void deleteClient(@PathVariable Long id)
    {
        iClientService.deleteClient(id);
    }


}

