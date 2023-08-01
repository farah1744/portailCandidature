package ma.gov.mhpv.PortailCandidature.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.gov.mhpv.PortailCandidature.DTO.DomaineDTO;
import ma.gov.mhpv.PortailCandidature.service.IDomaineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/Domaines")
@Tag(name = "Domaine API", description = "API pour gerer les domaines")

public class DomaineController {
    private IDomaineService domaineService ;

    @GetMapping("/getAllDomaines")
    @Operation(summary = "Recuperation de la liste de tous les domaines")

    public List<DomaineDTO> getAllDomaines(){
        return domaineService.getAllDomaines();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Recupere un domaine par son identifiant")

    public ResponseEntity<DomaineDTO> getDomaineById(@PathVariable("id") int idDomaine) {
        DomaineDTO domaineDTO = domaineService.getDomaineById(idDomaine);
        if (domaineDTO != null) {
            return ResponseEntity.ok(domaineDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Creation d'un nouveau domaine")

    public ResponseEntity<Void> createDomaine(@RequestBody DomaineDTO domaineDTO) {
        domaineService.createDomaine(domaineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //bad request
    @PutMapping("/{id}")
    @Operation(summary = "modifier un domaine ")

    public ResponseEntity<Void> updateDomaine(@PathVariable("id") int idDomaine, @RequestBody DomaineDTO domaineDTO) {
        domaineService.updateDomaine(idDomaine, domaineDTO);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "supprimer un domaine ")
    public ResponseEntity<Void> deleteDomaine(@PathVariable("id") int idDomaine) {
        domaineService.deleteDomaine(idDomaine);
        return ResponseEntity.ok().build();
    }
}
