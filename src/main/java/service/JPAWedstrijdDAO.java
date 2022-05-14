package service;

import domain.Stadion;
import domain.Wedstrijd;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("wedstrijdDAO")
public class JPAWedstrijdDAO implements WedstrijdDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Wedstrijd> findAll() {
        TypedQuery<Wedstrijd> query = em.createNamedQuery("Wedstrijd.findAll", Wedstrijd.class);
        return query.getResultList();
    }

    @Override
    public List<Wedstrijd> findInStadion(Stadion stadion) {
        TypedQuery<Wedstrijd> query = em.createNamedQuery("Wedstrijd.inStadion", Wedstrijd.class).setParameter("stadion", stadion);
        return query.getResultList();
    }

    @Override
    public Wedstrijd findById(Long id) {
        TypedQuery<Wedstrijd> query = em.createNamedQuery("Wedstrijd.byID", Wedstrijd.class).setParameter("id", id);
        return query.getSingleResult();
    }
}

