package fr.eni.cave.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.cave.bo.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

}
