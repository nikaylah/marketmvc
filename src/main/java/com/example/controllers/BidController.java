package com.example.controllers;

import com.example.domain.Bid;
import com.example.domain.Contractor;
import com.example.domain.Project;
import com.example.services.BidService;
import com.example.services.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/bid")
@Controller
public class BidController {

    private BidService bidService;

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @RequestMapping({"/list", "/"})
    public String listBid(Model model){
        model.addAttribute("bid", bidService.listAll());
        return "bid/list";
    }

    @RequestMapping("/show/{id}")
    public String showBid(@PathVariable Integer id, Model model){
        model.addAttribute("bid", bidService.getById(id));
        return "bid/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("bid", bidService.getById(id));
        return "bid/bidform";
    }

    @RequestMapping("/new")
    public String newBid(Model model){
        model.addAttribute("bid", new Bid());
        return "bid/bidform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Bid bid){
        Bid newBid = bidService.saveOrUpdate(bid);
        return "redirect:bid/show/" + newBid.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        bidService.delete(id);
        return "redirect:/bid/list";
    }
}


