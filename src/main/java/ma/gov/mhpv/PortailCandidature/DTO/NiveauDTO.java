package ma.gov.mhpv.PortailCandidature.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class NiveauDTO {
    private int id;
    private String libelle;
}
