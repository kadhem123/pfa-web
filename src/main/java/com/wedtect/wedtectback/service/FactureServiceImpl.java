package com.wedtect.wedtectback.service;

import com.wedtect.wedtectback.Facture.BillNotFoundException;
import com.wedtect.wedtectback.entities.Facture;
import com.wedtect.wedtectback.dao.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class FactureServiceImpl implements FactureService{
    @Autowired
    private FactureRepository repo;

    @Override
    public List<Facture> findAll(){
        return (List<Facture>) repo.findAll();
    }

    public Facture save(Facture fact){
        return repo.save(fact);

    }

    public Facture get(Long id) throws BillNotFoundException {
        Optional<Facture> result=repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new BillNotFoundException("Could not find any bill with id" + id);
    }

    public void delete(Long id) throws BillNotFoundException {
        Long count=  repo.countById(id);
        if(count == null || count == 0){
            throw new BillNotFoundException("Could not find any bill with id" + id);
        }
        repo.deleteById(id);
    }
}
