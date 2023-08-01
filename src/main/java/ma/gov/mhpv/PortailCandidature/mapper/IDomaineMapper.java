package ma.gov.mhpv.PortailCandidature.mapper;

import ma.gov.mhpv.PortailCandidature.DTO.DomaineDTO;
import ma.gov.mhpv.PortailCandidature.model.Diplome;
import ma.gov.mhpv.PortailCandidature.model.Domaine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDomaineMapper {
    IDiplomeMapper INSTANCE = Mappers.getMapper(IDiplomeMapper.class);
    Domaine mapToDomaine (DomaineDTO domaineDTO);
    DomaineDTO mapToDomaineDTO(Domaine domaine);
    List<Domaine> mapToDomaine(List<DomaineDTO> domaineDTOList);
    List<DomaineDTO> mapToDomaineDTO(List<Domaine> domaineList);



}
