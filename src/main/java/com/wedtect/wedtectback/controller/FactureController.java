package com.wedtect.wedtectback.controller;
import com.wedtect.wedtectback.Facture.BillNotFoundException;
import com.wedtect.wedtectback.service.FactureService;
import com.wedtect.wedtectback.entities.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FactureController {
    @Autowired private FactureService service;

    @GetMapping("/factures")
    public String showBillsList(Model model){
        List<Facture> listFactures = service.findAll();
        model.addAttribute("listFactures", listFactures);
        return "factures";
    }
    @GetMapping("/factures/new")
    public String showNewForm(Model model){
        model.addAttribute("fact",new Facture());
        model.addAttribute("pageTitle", "Add new bill");
        return "factureform";
    }
    @PostMapping("/factures/save")
    public String saveBill(Facture fact, RedirectAttributes ra){
        ra.addFlashAttribute("message", "Bill has been saved Successfully");
        service.save(fact);
        return "redirect:/factures";
    }

    @GetMapping("/factures/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
        try{
            Facture fact = service.get(id);
            model.addAttribute("facture", fact);
            model.addAttribute("pageTitle", "Edit Bill(ID:" + id + ")");
            return "factureform";
        }catch(BillNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            //"User has been saved successfully"
            return "redirect:/factures";
        }
    }

    @GetMapping("/factures/delete/{id}")
    public String DeleteBill(@PathVariable("id") Long id, RedirectAttributes ra){
        try{
            service.delete(id);
            ra.addFlashAttribute("message","Bill with ID" + id + "has been deleted successfully");
        }catch(BillNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            //"User deleted successfully"
        }
        return "redirect:/factures";
    }

}
