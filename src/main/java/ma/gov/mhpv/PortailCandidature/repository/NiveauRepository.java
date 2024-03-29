package ma.gov.mhpv.PortailCandidature.repository;

import ma.gov.mhpv.PortailCandidature.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Integer> {
}
