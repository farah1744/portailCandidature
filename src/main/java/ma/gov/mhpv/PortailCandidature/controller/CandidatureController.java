package ma.gov.mhpv.PortailCandidature.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.gov.mhpv.PortailCandidature.DTO.CandidatureDTO;
import ma.gov.mhpv.PortailCandidature.service.ICandidatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Candidatures")
@AllArgsConstructor
@Tag(name = "Candidature API", description = "API pour gerer les candidatures")
public class CandidatureController {
    private ICandidatureService candidatureService ;
    @Operation(summary = "Recuperation de la liste de toutes les candidatures")
    @GetMapping("/getAllCandidatures")
    public List<CandidatureDTO> getAllCandidatures(){
        return candidatureService.getAllCandidature();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Recupere une candidature par son identifiant")

    public ResponseEntity<CandidatureDTO> getCandidatureById(@PathVariable("id") int idCandidature) {
        CandidatureDTO candidatureDTO = candidatureService.getCandidatureById(idCandidature);
        if (candidatureDTO != null) {
            return ResponseEntity.ok(candidatureDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Creation d'une nouvelle candidature")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product added successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<Void> createCandidature(@RequestBody CandidatureDTO candidatureDTO) {
        candidatureService.createCandidature(candidatureDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
//bad request
    @PutMapping("/{id}")
    @Operation(summary = "modifier une candidature ")
    public ResponseEntity<Void> updateCandidature(@PathVariable("id") int idCandidature, @RequestBody CandidatureDTO candidatureDTO) {
        candidatureService.updateCandidature(idCandidature, candidatureDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "supprimer une candidature ")

    public ResponseEntity<Void> deleteCandidature(@PathVariable("id") int idCandidature) {
        candidatureService.deleteCandidature(idCandidature);
        return ResponseEntity.ok().build();
    }

}
