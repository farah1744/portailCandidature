package ma.gov.mhpv.PortailCandidature.DTO;

import jakarta.persistence.*;
import lombok.Data;


@Data
public class DomaineDTO {
    private int id;
    private String libelle;
}
