package com.wedtect.wedtectback.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wedtect.wedtectback.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
    Client findByMail(String mail);
    List<Client> findByNomStartingWith(String caractere);

}
