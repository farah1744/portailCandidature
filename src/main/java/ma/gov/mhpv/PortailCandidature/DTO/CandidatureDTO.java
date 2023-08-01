package ma.gov.mhpv.PortailCandidature.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class CandidatureDTO {
    private int id;
    private String prennom;
    private String nom;
    private String cnie;
    private Date dateNaissance;
    private String sexe;
    private String adresse;
    private int codePostal;
    private Long numTel;
    private DiplomeDTO diplome;
}
