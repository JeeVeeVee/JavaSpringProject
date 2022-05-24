package com.example.springboottutorial.controllers;

import domain.Stadion;
import domain.TicketOrder;
import service.DAO.Stadion.StadionDAO;
import service.VoetbalService;
import service.DAO.Wedstrijd.WedstrijdDAO;
import validator.TicketOrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/fifa")
public class FifaController {

    @Autowired
    private VoetbalService voetbalService;

    @Autowired
    private StadionDAO stadionDAO;

    @Autowired
    private WedstrijdDAO wedstrijdDAO;

    @Autowired
    private TicketOrderValidator ticketOrderValidator;

    @Value("#{ messageSource.getMessage('admin.email',null,'en')}")
    private String email;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("stadionlist", stadionDAO.findAll());
        model.addAttribute("stadion", new Stadion(""));
        return "home";
    }

    @PostMapping("/")
    public String postmapping( @ModelAttribute Stadion stadion, Model model){
        model.addAttribute("tickets", wedstrijdDAO.findInStadion(stadion));
        model.addAttribute("plek", stadion.getName());
        return "stadion";
    }

    @RequestMapping("/{matchId}")
    public String matchDetail(@PathVariable(value="matchId") String id, Model model){
        model.addAttribute("wedstrijd", wedstrijdDAO.findById(Long.valueOf(id)));
        model.addAttribute("ticketOrder", new TicketOrder());
        return "detail";
    }

    @PostMapping("/{matchId}")
    public String buyTickets(@Valid @ModelAttribute TicketOrder order, BindingResult bindingResult, Model model) {
        ticketOrderValidator.validate(order, bindingResult);
        if(bindingResult.hasErrors()){
            return "detail";
        }
        model.addAttribute("ticket", voetbalService.getWedstrijd(
                "4"
        ));
        return "redirect:/fifa";
    }
}