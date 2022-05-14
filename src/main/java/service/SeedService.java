package service;

import domain.Stadion;
import domain.Wedstrijd;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class SeedService {
    @PersistenceContext
    private EntityManager em;

    public void seed() {

        Stadion stadion2 = new Stadion("Al Thumama Stadium");
        stadion2.setId(10);
        //saveStadion(stadion2);
        Stadion stadion1 = new Stadion("Al Bayt Stadium");
        stadion1.setId(11);
        //saveStadion(stadion1);

        Wedstrijd w1 = new Wedstrijd("Belgie", "Canada", 26, 21, 35, stadion1);
        w1.setId(0L);
        saveWedstrijd(w1);
        Wedstrijd w2 = new Wedstrijd("Brazilië", "Zwitserland", 27, 18, 21, stadion2);
        w2.setId(0L);
        saveWedstrijd(w2);
        Wedstrijd w3 = new Wedstrijd("Marroko", "Kroatië", 28, 15, 5, stadion1);
        w3.setId(2L);
        saveWedstrijd(w3);
        Wedstrijd w4 = new Wedstrijd("Spanje", "Duitsland", 28, 18, 95, stadion2);
        w4.setId(3L);
        saveWedstrijd(w4);
        Wedstrijd w5 = new Wedstrijd("Frankrijk", "Denemarken", 30, 15, 45, stadion1);
        w5.setId(4L);
        saveWedstrijd(w5);
        Wedstrijd w6 = new Wedstrijd("Argentinië", "Mexico", 30, 18, 10, stadion2);
        w6.setId(5L);
        saveWedstrijd(w6);
        Wedstrijd w7 = new Wedstrijd("Engeland", "USA", 31, 18, 22, stadion1);
        w7.setId(6L);
        saveWedstrijd(w7);
        Wedstrijd w8 = new Wedstrijd("Nederland", "Qatar", 31, 21, 16, stadion2);
        w8.setId(7L);
        saveWedstrijd(w8);


    }

    public void saveStadion(Stadion stadion) {
        em.persist(stadion);
        em.flush();
        em.clear();
    }

    public void saveWedstrijd(Wedstrijd wedstrijd) {
        em.persist(wedstrijd);
        em.flush();
        em.clear();
    }
}
