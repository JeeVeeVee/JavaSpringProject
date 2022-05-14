package com.example.springboottutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.*;
import validator.TicketOrderValidator;

@SpringBootApplication
public class SpringBootTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
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
