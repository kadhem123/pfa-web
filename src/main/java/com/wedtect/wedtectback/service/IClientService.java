package com.wedtect.wedtectback.service;
import java.util.List;
import com.wedtect.wedtectback.entities.Client;

public interface IClientService {
    public Client addClient(Client s);
    public void deleteClient(Long id);
    public Client updateClient(Client c);
    public Client findClient(Long id);
    public List<Client> findAll();
    public Client findByMail(String mail);
    public List<Client> findByNom(String nom);
}
