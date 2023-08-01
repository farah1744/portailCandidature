package ma.gov.mhpv.PortailCandidature.mapper;

import ma.gov.mhpv.PortailCandidature.DTO.CandidatureDTO;
import ma.gov.mhpv.PortailCandidature.DTO.DiplomeDTO;
import ma.gov.mhpv.PortailCandidature.model.Candidature;
import ma.gov.mhpv.PortailCandidature.model.Diplome;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring", uses = {IDomaineMapper.class, INiveauMapper.class})
//@Mapper(componentModel = "spring", uses = {INiveauMapper.class})

public interface IDiplomeMapper {
    IDiplomeMapper INSTANCE = Mappers.getMapper(IDiplomeMapper.class);
    Diplome mapToDiplome(DiplomeDTO diplomeDTO);
    DiplomeDTO mapToDiplomeDTO(Diplome diplome);
    List<Diplome> mapToDiplome(List<DiplomeDTO> DiplomeDTOList) ;
    List<DiplomeDTO> mapToDiplomeDTO(List<Diplome> DiplomeList) ;
}
