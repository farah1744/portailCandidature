package ma.gov.mhpv.PortailCandidature.DTO;

import lombok.Data;
@Data
public class DiplomeDTO {
    private int id;
    private String nom;
    private String specialite;
    private String etablissement;
    private int anneeObtention;
    private boolean type;
    private DomaineDTO domaine;
    private NiveauDTO niveau;
}
