package domain;

import validator.validEmail.ValidEmail;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Entity
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "moet ingevuld zijn")
    @ValidEmail
    private String email;

    @Min(1)
    @Max(25)
    private Integer aantalTickets = 1;

    @Min(1)
    @Max(25)
    private Integer voetbalCode1 = 10;

    @Min(1)
    @Max(25)
    @NumberFormat()
    private Integer voetbalCode2 = 20;



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


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
