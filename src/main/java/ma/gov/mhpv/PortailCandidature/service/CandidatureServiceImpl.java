package ma.gov.mhpv.PortailCandidature.service;

import lombok.AllArgsConstructor;
import ma.gov.mhpv.PortailCandidature.DTO.CandidatureDTO;
import ma.gov.mhpv.PortailCandidature.mapper.ICandidatureMapper;
import ma.gov.mhpv.PortailCandidature.model.Candidature;
import ma.gov.mhpv.PortailCandidature.repository.CandidatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CandidatureServiceImpl implements ICandidatureService{
    private CandidatureRepository candidatureRepository;
    private ICandidatureMapper candidatureMapper;

    @Override
    public List<CandidatureDTO> getAllCandidature() {
        List<Candidature> candidatures = candidatureRepository.findAll();
        return candidatureMapper.mapToCandidatureDTO(candidatures);
    }

    @Override
    public CandidatureDTO getCandidatureById(Integer candidatureId) {
        Candidature candidature = candidatureRepository.findById(candidatureId).orElse(null);
        if (candidature != null) {
            return candidatureMapper.mapToCandidatureDTO(candidature);
        }
        return null;
    }



    @Override
    public void createCandidature(CandidatureDTO candidatureDTO) {
        Candidature candidature = candidatureMapper.mapToCandidature(candidatureDTO);
        candidatureRepository.save(candidature);
    }

    @Override
    public void updateCandidature(int candidatureId, CandidatureDTO candidatureDTO) {
        Candidature existingCandidature = candidatureRepository.findById(candidatureId).orElse(null);
        if (existingCandidature != null) {
            Candidature updatedCandidature = candidatureMapper.mapToCandidature(candidatureDTO);
            updatedCandidature.setId(existingCandidature.getId());
            candidatureRepository.save(updatedCandidature);
        }

    }

    @Override
    public void deleteCandidature(Integer CandidatureId) {
        candidatureRepository.deleteById(CandidatureId);
    }
}
