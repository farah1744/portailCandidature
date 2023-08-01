package ma.gov.mhpv.PortailCandidature.repository;

import ma.gov.mhpv.PortailCandidature.model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {
}
