package com.sysy.maliTourist.repository;
import com.sysy.maliTourist.models.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //indique que la classe à pour rôle de communiquer avec une source de données
public interface PopulationRepository extends JpaRepository<Population, Long> {
}
