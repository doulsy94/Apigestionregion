package com.sysy.maliTourist.repository;

import com.sysy.maliTourist.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //indique que la classe à pour rôle de communiquer avec une source de données
public interface RegionRepository extends JpaRepository<Region, Long> {
//@query défini la méthode comme une réquêtte SQL
    @Query(value = "SELECT region.nom_region, region.domaine_activite_region, " +
            "region.langue_majoritaire, population.nbre_habitant, region.superficie, " +
            "population.annee, pays.nom_pays as pays FROM region, pays, population" +
            " where region.pays_code_pays = pays.code_pays " +
            "and region.id_region = population.region_id_region", nativeQuery = true )
    public Iterable<Object[]> REGION_WITH_PAYS();

    @Query(value = "SELECT region.nom_region, region.domaine_activite_region," +
                   "region.langue_majoritaire, population.nbre_habitant, region.superficie," +
                   "population.annee FROM region, population  " +
                    "where region.id_region = population.region_id_region", nativeQuery = true )
    public Iterable<Object[]> REGION_SANS_Pays();

    @Query(value = "SELECT region.nom_region, region.domaine_activite_region," +
                    "region.langue_majoritaire, population.nbre_habitant, region.superficie," +
                    "population.annee  FROM region, population where " +
                "region.id_region = population.region_id_region", nativeQuery = true )
    public Iterable<Object[]> REGION_EN_FONCTION_DU_Pays(String pays);

}

