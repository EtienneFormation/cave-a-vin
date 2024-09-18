package fr.eni.cave.controllers;

import fr.eni.cave.bo.Bouteille;
import fr.eni.cave.services.BouteilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/caveavin/bouteilles")
public class BouteilleController {
    @Autowired
    private BouteilleService bouteilleService;

    @GetMapping
    public ResponseEntity<?> getAllBouteilles() {
        List<Bouteille> bouteilles = bouteilleService.chargerToutesBouteilles();
        if (bouteilles == null || bouteilles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bouteilles);
    }
}
