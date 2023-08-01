package ma.gov.mhpv.PortailCandidature.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor

public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Diplome")
    private String nom;
    @Column(name = "Specialite")
    private String specialite;
    @Column(name = "Etablissement")
    private String etablissement;
    @Column(name = "Annee")
    private int anneeObtention;
    @Column(name = "Type")
    private boolean type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "domaine_id")
    private Domaine domaine;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Niveau_id")
    private Niveau niveau;


}
