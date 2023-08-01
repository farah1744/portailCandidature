package ma.gov.mhpv.PortailCandidature.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.gov.mhpv.PortailCandidature.DTO.NiveauDTO;
import ma.gov.mhpv.PortailCandidature.service.INiveauService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/Niveau")
@Tag(name = "Niveau API", description = "API pour gerer les niveaux")

public class NiveauController {
    private  INiveauService niveauService ;

    @GetMapping("/getAllNiveau")
    @Operation(summary = "Recuperation de la liste de tous les niveaux")
    public List<NiveauDTO> getAllNiveau(){
        return niveauService.getAllNiveau();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Recupere un niveau par son identifiant")

    public ResponseEntity<NiveauDTO> getNiveauById(@PathVariable("id") int idNiveau) {
        NiveauDTO niveauDTO = niveauService.getNiveauById(idNiveau);
        if (niveauDTO != null) {
            return ResponseEntity.ok(niveauDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Creation d'un nouveau niveau")

    public ResponseEntity<Void> createNiveau(@RequestBody NiveauDTO niveauDTO) {
        niveauService.createNiveau(niveauDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //bad request
    @PutMapping("/{id}")
    @Operation(summary = "modifier un niveau ")

    public ResponseEntity<Void> updateNiveau(@PathVariable("id") int idNiveau, @RequestBody NiveauDTO niveauDTO) {
        niveauService.updateNiveau(idNiveau, niveauDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "supprimer une niveau ")

    public ResponseEntity<Void> deleteDomaine(@PathVariable("id") int idNiveau) {
        niveauService.deleteNiveau(idNiveau);
        return ResponseEntity.ok().build();
    }
}
