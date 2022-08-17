package com.sysy.maliTourist.repository;
import com.sysy.maliTourist.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//indique que la classe à pour rôle de communiquer avec une source de données(en orurence DB)
@Repository
public interface PaysRepository extends JpaRepository<Pays, String> {
}
