package lat.fercejor.fercejorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lat.fercejor.fercejorapp.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    
}
