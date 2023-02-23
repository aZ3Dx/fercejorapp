package lat.fercejor.fercejorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lat.fercejor.fercejorapp.model.Credito;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {
    
}
