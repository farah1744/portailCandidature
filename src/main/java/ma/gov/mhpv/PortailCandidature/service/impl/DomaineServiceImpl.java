package ma.gov.mhpv.PortailCandidature.service;

import lombok.AllArgsConstructor;
import ma.gov.mhpv.PortailCandidature.DTO.DomaineDTO;
import ma.gov.mhpv.PortailCandidature.mapper.IDomaineMapper;
import ma.gov.mhpv.PortailCandidature.model.Domaine;
import ma.gov.mhpv.PortailCandidature.repository.DomaineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DomaineServiceImpl implements IDomaineService {

    private  DomaineRepository domaineRepository;
    private  IDomaineMapper domaineMapper;



    @Override
    public List<DomaineDTO> getAllDomaines() {
        List<Domaine> domaines = domaineRepository.findAll();
        return domaineMapper.mapToDomaineDTO(domaines);
    }

    @Override
    public DomaineDTO getDomaineById(int DomaineId) {
        Domaine domaine = domaineRepository.findById(DomaineId).orElse(null);
        if(domaine != null){
            return domaineMapper.mapToDomaineDTO(domaine);
        }
        return null;
    }

    @Override
    public void createDomaine(DomaineDTO domaineDTO) {
        Domaine domaine = domaineMapper.mapToDomaine(domaineDTO);
        domaineRepository.save(domaine);
    }

    @Override
    public void updateDomaine(int domaineId, DomaineDTO domaineDTO) {
        Domaine existingDomaine = domaineRepository.findById(domaineId).orElse(null);
        if(existingDomaine != null){
            Domaine updatedDomaine = domaineMapper.mapToDomaine(domaineDTO);
            updatedDomaine.setId(existingDomaine.getId());
            domaineRepository.save(updatedDomaine);
        }

    }

    @Override
    public void deleteDomaine(int domaineId) {
        domaineRepository.deleteById(domaineId);
    }
}
