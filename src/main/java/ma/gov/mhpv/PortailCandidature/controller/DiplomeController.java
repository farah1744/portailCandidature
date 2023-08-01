package ma.gov.mhpv.PortailCandidature.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.gov.mhpv.PortailCandidature.DTO.DiplomeDTO;
import ma.gov.mhpv.PortailCandidature.service.IDiplomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Diplomes")
@Tag(name = "Diplomes API", description = "API pour gerer les diplomes")

public class DiplomeController {
        private IDiplomeService diplomeService ;
        @GetMapping("/getAllDiplomes")
        @Operation(summary = "Recuperation de la liste de tous les diplomes")

        public List<DiplomeDTO> getAllDiplomes(){
            return diplomeService.getAllDiplome();
        }
        @GetMapping("/{id}")
        @Operation(summary = "Recupere un diplome par son identifiant")

        public ResponseEntity<DiplomeDTO> getDiplomeById(@PathVariable("id") int idDiplome) {
            DiplomeDTO diplomeDTO = diplomeService.getDiplomeById(idDiplome);
            if (diplomeDTO != null) {
                return ResponseEntity.ok(diplomeDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        @Operation(summary = "Creation d'un nouveau diplome")

        public ResponseEntity<Void> createDiplome(@RequestBody DiplomeDTO diplomeDTO) {
            diplomeService.createDiplome(diplomeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @PutMapping("/{id}")
        @Operation(summary = "modifier un diplome ")

        public ResponseEntity<Void> updateDiplome(@PathVariable("id") int idDiplome, @RequestBody DiplomeDTO diplomeDTO) {
            diplomeService.updateDiplome(idDiplome, diplomeDTO);
            return ResponseEntity.ok().build();
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "supprimer un diplome ")

        public ResponseEntity<Void> deleteDiplome(@PathVariable("id") int idDiplome) {
            diplomeService.deleteDiplome(idDiplome);
            return ResponseEntity.ok().build();
        }
}
