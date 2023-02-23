package lat.fercejor.fercejorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lat.fercejor.fercejorapp.model.HojaRuta;

@Repository
public interface HojaRutaRepository extends JpaRepository<HojaRuta, Long> {
    
}
