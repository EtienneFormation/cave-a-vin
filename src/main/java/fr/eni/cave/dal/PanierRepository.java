package fr.eni.cave.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.cave.bo.Panier;

public interface PanierRepository extends JpaRepository<Panier, Integer> {

}
