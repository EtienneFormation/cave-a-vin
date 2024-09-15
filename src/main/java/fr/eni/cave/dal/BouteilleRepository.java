package fr.eni.cave.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.cave.bo.Bouteille;
import fr.eni.cave.bo.Couleur;
import fr.eni.cave.bo.Region;

public interface BouteilleRepository extends JpaRepository<Bouteille, Integer> {
	// Rechercher des bouteilles par leur région
	List<Bouteille> findByRegion(@Param("r") Region r);

	// Rechercher des bouteilles par leur couleur
	List<Bouteille> findByCouleur(@Param("c") Couleur c);
}
