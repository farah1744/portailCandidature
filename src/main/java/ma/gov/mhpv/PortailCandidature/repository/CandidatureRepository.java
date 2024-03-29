package ma.gov.mhpv.PortailCandidature.repository;

import ma.gov.mhpv.PortailCandidature.model.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
}
