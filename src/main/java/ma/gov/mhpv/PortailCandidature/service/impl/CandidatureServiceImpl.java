package ma.gov.mhpv.PortailCandidature.service;
import lombok.AllArgsConstructor;
import ma.gov.mhpv.PortailCandidature.DTO.CandidatureDTO;
import ma.gov.mhpv.PortailCandidature.mapper.ICandidatureMapper;
import ma.gov.mhpv.PortailCandidature.model.Candidature;
import ma.gov.mhpv.PortailCandidature.repository.CandidatureRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor

  /*@Override
  public String genererCodeUnique() {
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
    StringBuilder codeBuilder = new StringBuilder();

    do {
      for (int i = 0; i < 8; i++) {
        int index = random.nextInt(caracteres.length());
        codeBuilder.append(caracteres.charAt(index));
      }
    } while (candidatureRepository.existsByCode(codeBuilder.toString()));

    return codeBuilder.toString();
  }
}*/

public class CandidatureServiceImpl implements ICandidatureService {
  private CandidatureRepository candidatureRepository;
  private ICandidatureMapper candidatureMapper;
  @Override
  public List<CandidatureDTO> getAllCandidatures() {
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
    candidature.setReference(genererCodeUnique());
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
  @Override
  public String genererCodeUnique() {
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
    StringBuilder codeBuilder = new StringBuilder();

    do {
      for (int i = 0; i < 8; i++) {
        int index = random.nextInt(caracteres.length());
        codeBuilder.append(caracteres.charAt(index));
      }
    } while (candidatureRepository.existsByCode(codeBuilder.toString()));

    return codeBuilder.toString();
  }
}
