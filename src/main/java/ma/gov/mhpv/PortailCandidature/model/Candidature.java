package ma.gov.mhpv.PortailCandidature.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table
@NoArgsConstructor
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Prenom_Candidat")
    private String prennom;
    @Column(name = "Nom_Candidat")
    private String nom;
    @Column(name = "CNIE")
    private String cnie;
    @Column(name = "Date_Naissance")
    private Date dateNaissance;
    @Column(name = "Sexe")
    private String sexe;
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Code_Postal")
    private int codePostal;
    @Column(name = "Num_Tel")
    private Long numTel;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Diplome")
    private Diplome diplome;
}
