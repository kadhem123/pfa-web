package com.wedtect.wedtectback.service;
import java.util.List;
import com.wedtect.wedtectback.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedtect.wedtectback.entities.Client;
@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client c){
        return clientRepository.save(c);
    }
    public void deleteClient(Long id) {
        if(clientRepository.findById(id).isPresent())
            clientRepository.deleteById(id);
    }
    public Client updateClient(Client p) {
        return clientRepository.saveAndFlush(p);
    }
    public Client findClient(Long id) {
        return clientRepository.findById(id).get();
    }
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    public Client findByMail(String mail) {

        return clientRepository.findByMail(mail);
    }
    public List<Client> findByNom(String nom) {
        return clientRepository.findByNomStartingWith(nom);
    }
}
