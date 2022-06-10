package domain;

import org.springframework.beans.factory.annotation.Required;
import validator.validEmail.ValidEmail;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


public class TicketOrder {

    @NotNull(message = "{validation.empty}")
    @NotEmpty(message = "moet ingevuld zijn")
    @ValidEmail
    private String email;

    @NotNull(message = "{validation.empty}")
    @Min(1)
    @Max(25)
    private int aantalTickets = 1;

    @NotNull(message = "moet ingevuld zijn ")
    @Min(1)
    @Max(25)
    private Integer voetbalCode1 = 10;

    @NotNull(message = "moet ingevuld zijn ")
    @Min(1)
    @Max(25)
    @NumberFormat()
    private Integer voetbalCode2 = 20;


    private Integer beschikbareTickets = 0;

    public Integer getBeschikbareTickets() {
        return beschikbareTickets;
    }

    public void setBeschikbareTickets(Integer beschikbareTickets) {
        this.beschikbareTickets = beschikbareTickets;
    }


    public TicketOrder() {
        //this.beschikbareTickets = wedstrijd.getTickets_left();
    }



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
}
