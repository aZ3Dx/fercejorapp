package lat.fercejor.fercejorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lat.fercejor.fercejorapp.model.Transporte;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {
    
}
