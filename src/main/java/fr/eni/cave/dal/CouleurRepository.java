package fr.eni.cave.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.cave.bo.Couleur;

public interface CouleurRepository extends JpaRepository<Couleur, Integer> {

}
