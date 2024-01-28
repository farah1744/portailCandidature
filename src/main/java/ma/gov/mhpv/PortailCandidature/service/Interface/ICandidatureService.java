package ma.gov.mhpv.PortailCandidature.service;

import ma.gov.mhpv.PortailCandidature.DTO.CandidatureDTO;

import java.util.List;

public interface ICandidatureService {
    List<CandidatureDTO> getAllCandidatures();
    CandidatureDTO getCandidatureById(Integer candidatureId);
    void createCandidature(CandidatureDTO candidatureDTO);
    void updateCandidature(int candidatureId, CandidatureDTO candidatureDTO);
    void deleteCandidature(Integer CandidatureId);
    String genererCodeUnique();

}
