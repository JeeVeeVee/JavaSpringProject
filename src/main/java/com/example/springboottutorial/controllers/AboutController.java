package com.example.springboottutorial.controllers;

import com.example.springboottutorial.domain.Stadion;
import com.example.springboottutorial.domain.TicketOrder;
import com.example.springboottutorial.service.VoetbalService;
import com.example.springboottutorial.service.VoetbalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

@Controller
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private VoetbalService voetbalService;

    @Value("#{ messageSource.getMessage('admin.email',null,'en')}")
    private String email;

    @GetMapping
    public String courtReservation(Model model) {
        model.addAttribute("email", email);
        model.addAttribute("stadionlist", voetbalService.getStadiumList());
        model.addAttribute("stadion", new Stadion(""));
        return "home";
    }

    @PostMapping
    public String postmapping(@ModelAttribute Stadion stadion, BindingResult result, Model model){
        model.addAttribute("tickets", voetbalService.getWedstrijdenByStadium(stadion.getName()));
        return "stadion";
    }

    @RequestMapping("/{matchId}")
    public String matchDetail(@PathVariable(value="matchId") String id, Model model){
        model.addAttribute("ticket", voetbalService.getWedstrijd(id));
        model.addAttribute("ticketOrder", new TicketOrder());
        return "detail";
    }
}