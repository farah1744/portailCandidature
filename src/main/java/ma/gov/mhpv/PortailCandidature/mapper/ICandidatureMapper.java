package ma.gov.mhpv.PortailCandidature.mapper;

import jdk.jfr.Category;
import ma.gov.mhpv.PortailCandidature.DTO.CandidatureDTO;
import ma.gov.mhpv.PortailCandidature.model.Candidature;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IDiplomeMapper.class})

public interface ICandidatureMapper {
    ICandidatureMapper INSTANCE = Mappers.getMapper(ICandidatureMapper.class);
    Candidature mapToCandidature(CandidatureDTO candidatureDTO);
    CandidatureDTO mapToCandidatureDTO(Candidature candidature);
    List<Candidature> mapToCandidature(List<CandidatureDTO> candidaturetDTOList) ;
    List<CandidatureDTO> mapToCandidatureDTO(List<Candidature> candidaturetList) ;

}
