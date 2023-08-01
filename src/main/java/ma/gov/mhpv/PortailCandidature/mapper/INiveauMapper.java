package ma.gov.mhpv.PortailCandidature.mapper;

import ma.gov.mhpv.PortailCandidature.DTO.DomaineDTO;
import ma.gov.mhpv.PortailCandidature.DTO.NiveauDTO;
import ma.gov.mhpv.PortailCandidature.model.Domaine;
import ma.gov.mhpv.PortailCandidature.model.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface INiveauMapper {
    INiveauMapper INSTANCE = Mappers.getMapper(INiveauMapper.class);
    Niveau mapToNiveau (NiveauDTO niveauDTO);
    NiveauDTO mapToNiveauDTO(Niveau niveau);
    List<Niveau> mapToNiveau(List<NiveauDTO> niveauDTOList);
    List<NiveauDTO> mapToNiveauDTO(List<Niveau> niveauList);
}
