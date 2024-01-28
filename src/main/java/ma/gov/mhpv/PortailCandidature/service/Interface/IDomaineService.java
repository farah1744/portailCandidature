package ma.gov.mhpv.PortailCandidature.service;

import ma.gov.mhpv.PortailCandidature.DTO.DomaineDTO;

import java.util.List;

public interface IDomaineService {
    List<DomaineDTO> getAllDomaines();

    DomaineDTO getDomaineById(int DomaineId);

    void createDomaine(DomaineDTO domaineDTO);

    void updateDomaine(int domaineId, DomaineDTO domaineDTO);

    void deleteDomaine(int domaineId);
}
