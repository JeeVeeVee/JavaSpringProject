package service;

import domain.Stadion;
import domain.Wedstrijd;

import java.util.List;

public interface WedstrijdDAO {
    public List<Wedstrijd> findAll();
    public List<Wedstrijd> findInStadion(Stadion stadion);
    public Wedstrijd findById(Long id);
}
