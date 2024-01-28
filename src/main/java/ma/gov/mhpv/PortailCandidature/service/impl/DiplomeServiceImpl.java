package ma.gov.mhpv.PortailCandidature.service;

import lombok.AllArgsConstructor;
import ma.gov.mhpv.PortailCandidature.DTO.DiplomeDTO;
import ma.gov.mhpv.PortailCandidature.mapper.IDiplomeMapper;
import ma.gov.mhpv.PortailCandidature.model.Diplome;
import ma.gov.mhpv.PortailCandidature.repository.DiplomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiplomeServiceImpl implements IDiplomeService {
    private DiplomeRepository diplomeRepository;
    private IDiplomeMapper diplomeMapper;


    @Override
    public List<DiplomeDTO> getAllDiplome() {
        List<Diplome> diplomes = diplomeRepository.findAll();
        return diplomeMapper.mapToDiplomeDTO(diplomes);
    }

    @Override
    public DiplomeDTO getDiplomeById(Integer diplomeId) {
        Diplome diplome = diplomeRepository.findById(diplomeId).orElse(null);
        if (diplome != null) {
            return diplomeMapper.mapToDiplomeDTO(diplome);
        }
        return null;
    }

    @Override
    public void createDiplome(DiplomeDTO diplomeDTO) {
        Diplome diplome = diplomeMapper.mapToDiplome(diplomeDTO);
        diplomeRepository.save(diplome);
    }

    @Override
    public void updateDiplome(int DiplomeId, DiplomeDTO diplomeDTO) {
        Diplome existingDiplome = diplomeRepository.findById(DiplomeId).orElse(null);
        if (existingDiplome != null) {
            Diplome updatedDiplome = diplomeMapper.mapToDiplome(diplomeDTO);
            updatedDiplome.setId(existingDiplome.getId());
            diplomeRepository.save(updatedDiplome);
        }
    }

    @Override
    public void deleteDiplome(int diplomeId) {
        diplomeRepository.deleteById(diplomeId);
    }
}

