package ma.gov.mhpv.PortailCandidature.service;

import ma.gov.mhpv.PortailCandidature.DTO.NiveauDTO;
import ma.gov.mhpv.PortailCandidature.mapper.INiveauMapper;
import ma.gov.mhpv.PortailCandidature.model.Niveau;
import ma.gov.mhpv.PortailCandidature.repository.NiveauRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NiveauServiceImpl implements INiveauService{
    private final NiveauRepository niveauRepository;
    private final INiveauMapper niveauMapper;

    public NiveauServiceImpl(NiveauRepository niveauRepository,INiveauMapper niveauMapper) {
        this.niveauRepository = niveauRepository;
        this.niveauMapper = niveauMapper;

    }

    @Override
    public List<NiveauDTO> getAllNiveau() {
        List<Niveau> niveaus = niveauRepository.findAll();
        return niveauMapper.mapToNiveauDTO(niveaus);
    }

    @Override
    public NiveauDTO getNiveauById(int NiveauId) {
        Niveau niveau = niveauRepository.findById(NiveauId).orElse(null);
        if(niveau != null){
            return niveauMapper.mapToNiveauDTO(niveau);
        }
        return null;
    }

    @Override
    public void createNiveau(NiveauDTO niveauDTO) {
        Niveau niveau = niveauMapper.mapToNiveau(niveauDTO);
        niveauRepository.save(niveau);
    }

    @Override
    public void updateNiveau(int niveauId, NiveauDTO niveauDTO) {
        Niveau existingNiveau = niveauRepository.findById(niveauId).orElse(null);
        if(existingNiveau != null){
            Niveau updatedNiveau = niveauMapper.mapToNiveau(niveauDTO);
            updatedNiveau.setId(existingNiveau.getId());
            niveauRepository.save(updatedNiveau);
        }

    }

    @Override
    public void deleteNiveau(int niveauId) {
        niveauRepository.deleteById(niveauId);
    }
}
