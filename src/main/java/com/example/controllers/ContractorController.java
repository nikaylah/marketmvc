package com.example.controllers;

import com.example.domain.Contractor;
import com.example.services.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/contractor")
@Controller
public class ContractorController {

    private ContractorService contractorService;

    @Autowired
    public void setContractorService(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @RequestMapping({"/list", "/"})
    public String listContractor(Model model){
        model.addAttribute("contractor", contractorService.listAll());
        return "contractor/list";
    }

    @RequestMapping("/show/{id}")
    public String showContractor(@PathVariable Integer id, Model model){
        model.addAttribute("contractor", contractorService.getById(id));
        return "contractor/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("contractor", contractorService.getById(id));
        return "contractor/contractorform";
    }

    @RequestMapping("/new")
    public String newContractor(Model model){
        model.addAttribute("contractor", new Contractor());
        return "contractor/contractorform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Contractor contractor){
        Contractor newContractor = contractorService.saveOrUpdate(contractor);
        return "redirect:contractor/show/" + newContractor.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        contractorService.delete(id);
        return "redirect:/contractor/list";
    }
}
