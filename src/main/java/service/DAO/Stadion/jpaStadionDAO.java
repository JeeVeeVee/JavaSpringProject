package service.DAO.Stadion;

import domain.Stadion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("stadionDAO")
public class jpaStadionDAO implements StadionDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Stadion> findAll() {
        TypedQuery<Stadion> query = em.createNamedQuery("Stadion.findAll", Stadion.class);
        return query.getResultList();
    }
}
