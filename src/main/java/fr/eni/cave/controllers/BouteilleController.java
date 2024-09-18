package fr.eni.cave.controllers;

import fr.eni.cave.bo.Bouteille;
import fr.eni.cave.services.BouteilleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caveavin/bouteilles")
public class BouteilleController {
    private final BouteilleService bouteilleService;

    public BouteilleController(BouteilleService bouteilleService) {
        this.bouteilleService = bouteilleService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBouteilles() {
        List<Bouteille> bouteilles = bouteilleService.chargerToutesBouteilles();
        if (bouteilles == null || bouteilles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bouteilles);
    }

    // @RequestMapping

    @GetMapping("/{id}")
    // @RequestMapping(path = "/{id}", method = RequestMethod.GET) // alternative avec RequestMapping
    public ResponseEntity<?> getBouteilleById(@PathVariable("id") String id) {
        int idx;
        try {
            idx = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Format d'identifiant incorrect");
        }

        Bouteille bouteille = bouteilleService.chargerBouteilleParId(idx);
        if (bouteille == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(bouteille);
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<?> getBouteilleByRegionId(@PathVariable("id") String id) {
        int idx;
        try {
            idx = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Format d'identifiant incorrect");
        }

        List<Bouteille> bouteilles = bouteilleService.chargerBouteillesParRegion(idx);
        if (bouteilles == null || bouteilles.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(bouteilles);
    }

    @GetMapping("/couleur/{id}")
    public ResponseEntity<?> getBouteilleByCouleurId(@PathVariable("id") String id) {
        int idx;
        try {
            idx = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Format d'identifiant incorrect");
        }

        List<Bouteille> bouteilles = bouteilleService.chargerBouteillesParCouleur(idx);
        if (bouteilles == null || bouteilles.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(bouteilles);
    }
}
