package com.example.springboottutorial.domain;

public class TicketOrder {
    private String email;
    private int aantalTickets = 1;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAantalTickets() {
        return aantalTickets;
    }

    public void setAantalTickets(int aantalTickets) {
        this.aantalTickets = aantalTickets;
    }

    public int getVoetbalCode1() {
        return voetbalCode1;
    }

    public void setVoetbalCode1(int voetbalCode1) {
        this.voetbalCode1 = voetbalCode1;
    }

    public int getVoetbalCode2() {
        return voetbalCode2;
    }

    public void setVoetbalCode2(int voetbalCode2) {
        this.voetbalCode2 = voetbalCode2;
    }

    private int voetbalCode1 = 10;
    private int voetbalCode2 = 20;
}
