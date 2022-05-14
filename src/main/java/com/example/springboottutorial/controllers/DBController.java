package com.example.springboottutorial.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.SeedService;
import service.StadionDAO;
import service.WedstrijdDAO;

@Controller
@RequestMapping("/db")
public class DBController {
    @Autowired
    private StadionDAO stadionDAO;

    @Autowired
    private WedstrijdDAO wedstrijdDAO;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("stadionList", stadionDAO.findAll());
        model.addAttribute("wedstrijdList", wedstrijdDAO.findAll());
        model.addAttribute("wedstrijdDAO", wedstrijdDAO);
        return "db_results";
    }
}
