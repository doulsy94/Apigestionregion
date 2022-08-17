package com.sysy.maliTourist.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Population {
    @Id //le JPA est utilisé pour créer une clé primaire variable
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrementée dans la base de données
    @Column(name = "id_population")
    private long id_population;
    private int nbre_habitant;
    private int annee;

    //définition d'une rélation pusieurs-à-un entre region et population
    //Beaucoup de population peut etre associé à un seule objet de la classe region

    @ManyToOne
    private Region region;


}
