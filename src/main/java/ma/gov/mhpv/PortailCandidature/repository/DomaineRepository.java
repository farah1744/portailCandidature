package ma.gov.mhpv.PortailCandidature.repository;

import ma.gov.mhpv.PortailCandidature.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Integer> {
}
