package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({@NamedQuery(name = "Stadion.findAll", query = "SELECT s FROM Stadion s ORDER BY s.id")})

public class Stadion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;


    public Stadion(String name) {
        this.name = name;
    }

    public Stadion() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stadion stadion = (Stadion) o;
        return Objects.equals(stadion, stadion.id) && Objects.equals(name, stadion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Stadion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
