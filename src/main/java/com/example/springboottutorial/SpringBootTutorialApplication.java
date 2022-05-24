package com.example.springboottutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import service.*;
import service.DAO.Stadion.StadionDAO;
import service.DAO.Stadion.jpaStadionDAO;
import service.DAO.Wedstrijd.JPAWedstrijdDAO;
import service.VoetbalService;
import service.DAO.Wedstrijd.WedstrijdDAO;
import validator.TicketOrderValidator;

@SpringBootApplication
public class SpringBootTutorialApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("403");
    }

    @Bean
    public TicketOrderValidator ticketOrderValidator() {
        return new TicketOrderValidator();
    }

    @Bean
    public VoetbalService voetbalService() {
        return new VoetbalServiceImpl();
    }

    @Bean
    public SeedService seedService() {
        return new SeedService();
    }

    @Bean
    public StadionDAO stadionDAO() {
        return new jpaStadionDAO();
    }

    @Bean
    public WedstrijdDAO wedstrijdDAO(){
        return new JPAWedstrijdDAO();
    }
}
