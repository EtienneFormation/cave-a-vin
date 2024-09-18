package fr.eni.cave.services;

import java.util.List;

import fr.eni.cave.bo.Bouteille;

public interface BouteilleService {
	List<Bouteille> chargerToutesBouteilles();
	
	Bouteille chargerBouteilleParId(int idBouteille);

	List<Bouteille> chargerBouteillesParRegion(int idRegion);

	List<Bouteille> chargerBouteillesParCouleur(int idCouleur);
}
