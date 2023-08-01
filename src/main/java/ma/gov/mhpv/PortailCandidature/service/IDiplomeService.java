package ma.gov.mhpv.PortailCandidature.service;

import ma.gov.mhpv.PortailCandidature.DTO.CandidatureDTO;
import ma.gov.mhpv.PortailCandidature.DTO.DiplomeDTO;

import java.util.List;

public interface IDiplomeService {
    List<DiplomeDTO> getAllDiplome();
    DiplomeDTO getDiplomeById(Integer diplomeId);
    void createDiplome(DiplomeDTO diplomeDTO);
    void updateDiplome(int DiplomeId, DiplomeDTO diplomeDTO);

    void deleteDiplome(int diplomeId);
}
