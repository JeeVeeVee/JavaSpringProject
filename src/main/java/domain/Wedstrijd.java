package domain;


import javax.persistence.*;

//Een wedstrijd
@Entity
@NamedQueries({
        @NamedQuery(name = "Wedstrijd.findAll", query = "SELECT w FROM Wedstrijd w ORDER BY w.id"),
        @NamedQuery(name = "Wedstrijd.inStadion", query = "SELECT w from Wedstrijd w WHERE w.stadion = :stadion"),
        @NamedQuery(name = "Wedstrijd.byID", query = "SELECT w from Wedstrijd w WHERE w.id = :id")
})
public class Wedstrijd {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Wedstrijd() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    private String thuisland;

    private String uitland;
    private int dag; //dag van de wedstrijd

    private int uur; //uur van de wedstrijd


    private int tickets_left;

    public Stadion getStadion() {
        return stadion;
    }

    public void setStadion(Stadion stadion) {
        this.stadion = stadion;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Stadion stadion;


    public Wedstrijd(String id, String[] landen, int dag, int uur) {
        this.thuisland = landen[0];
        this.uitland = landen[1];
        this.dag = dag;
        this.uur = uur;
    }

    public Wedstrijd(String thuisland, String uitland, int dag, int uur, int tickets_left, Stadion stadion) {
        this.id = id;
        this.thuisland = thuisland;
        this.uitland = uitland;
        this.dag = dag;
        this.uur = uur;
        this.tickets_left = tickets_left;
        this.stadion = stadion;
    }

    public int getTickets_left() {
        return tickets_left;
    }

    public void setTickets_left(int tickets_left) {
        this.tickets_left = tickets_left;
    }

    public String[] getLanden() {
        return new String[]{thuisland, uitland};
    }

    public int getDag() {
        return dag;
    }

    public int getUur() {
        return uur;
    }

    public String getSamenvatting() {
        return String.format("%s vs %s op %d-11", thuisland, uitland, dag);
    }

    @Override
    public String toString() {
        return thuisland + " tegen " + uitland + " op "  + dag + " december,  om " + uur + ":00, in "  + stadion;
    }
}