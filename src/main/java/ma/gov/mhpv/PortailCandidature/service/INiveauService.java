package ma.gov.mhpv.PortailCandidature.service;

import ma.gov.mhpv.PortailCandidature.DTO.DomaineDTO;
import ma.gov.mhpv.PortailCandidature.DTO.NiveauDTO;
import ma.gov.mhpv.PortailCandidature.model.Niveau;

import java.util.List;

public interface INiveauService {
    List<NiveauDTO> getAllNiveau();

    NiveauDTO getNiveauById(int NiveauId);

    void createNiveau(NiveauDTO niveauDTO);

    void updateNiveau(int niveauId, NiveauDTO niveauDTO);

    void deleteNiveau(int niveauId);
}
