package ma.gov.mhpv.PortailCandidature.service;

import ma.gov.mhpv.PortailCandidature.DTO.CandidatureDTO;
import ma.gov.mhpv.PortailCandidature.repository.CandidatureRepository;

import java.util.List;

public interface ICandidatureService {
    List<CandidatureDTO> getAllCandidature();
    CandidatureDTO getCandidatureById(Integer candidatureId);
    void createCandidature(CandidatureDTO candidatureDTO);
    void updateCandidature(int candidatureId, CandidatureDTO productDTO);

    void deleteCandidature(Integer CandidatureId);

}
