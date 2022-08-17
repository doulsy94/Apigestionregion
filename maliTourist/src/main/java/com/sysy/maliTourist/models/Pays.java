package com.sysy.maliTourist.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
//POUR DEFINIR QU'UNE CLASSE EST UNE TABLE
@Entity

public class Pays {
    @Id //le JPA est utilisé pour créer une clé primaire variable
    // utilisé pour ajouter à la colone le nom dans la table d'une base de données Mysql
    @Column(name = "code_pays")
    private String code_pays;
    private String nom_pays;
}
