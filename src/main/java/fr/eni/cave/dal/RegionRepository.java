package fr.eni.cave.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.cave.bo.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {

}
