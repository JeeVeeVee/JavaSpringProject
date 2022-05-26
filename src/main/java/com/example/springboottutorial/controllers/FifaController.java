package com.example.springboottutorial.controllers;

import domain.Stadion;
import domain.TicketOrder;
import domain.Wedstrijd;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
import java.time.LocalDateTime;

@Controller
@RequestMapping("/fifa/")
@SessionAttributes("redirectOrder")
public class FifaController {

    @Autowired
    private VoetbalService voetbalService;

    @Autowired
    private StadionDAO stadionDAO;

    @Autowired
    private WedstrijdDAO wedstrijdDAO;

    @Autowired
    private TicketOrderValidator ticketOrderValidator;

    @ModelAttribute("redirectOrder")
    public TicketOrder redirectOrder() {
        return new TicketOrder(new Wedstrijd());
    }

    @Value("#{ messageSource.getMessage('admin.email',null,'en')}")
    private String email;

    @GetMapping
    public String home( @ModelAttribute("redirectOrder") TicketOrder order, Model model) {
        if(order != null){
            model.addAttribute("ordered_tickets", "you ordered tickets");
        }
        model.addAttribute("ordered_tickets", "you no buy tickets");
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
        Wedstrijd wedstrijd =  wedstrijdDAO.findById(Long.valueOf(id));
        model.addAttribute("wedstrijd",wedstrijd);
        TicketOrder ticketOrder = new TicketOrder(wedstrijd);
        model.addAttribute("ticketOrder", ticketOrder);
        return "detail";
    }

    @PostMapping("/{matchId}")
    public String buyTickets(@PathVariable(value="matchId") String id, @Valid @ModelAttribute TicketOrder order, BindingResult bindingResult, Model model, RedirectAttributes redirectOrder ){
        ticketOrderValidator.validate(order, bindingResult);
        Wedstrijd wedstrijd =  wedstrijdDAO.findById(Long.valueOf(id));
        model.addAttribute("wedstrijd",wedstrijd);
        if(bindingResult.hasErrors()){
            return "detail";
        }
        model.addAttribute("ticket", voetbalService.getWedstrijd(
                "4"
        ));
        redirectOrder.addFlashAttribute("redirectOrder" ,order);
        return "redirect:/fifa/";
    }

    @PostMapping("/logout")
    public String logout(@RequestParam(value = "error", required = false) String error,
                         @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "redirect:/login?logout";
    }
}