package com.sysy.maliTourist.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // annotation de lombok pour ne pas génerer les getters et les setters
@Setter
@Entity
public class Region {
    @Id // Permet de mapper l'ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genere l'auto incrementation de l'ID
    @Column(name = "id_region")
    private long id_region;
    private String code_region;
    private String nom_region;
    private String domaine_activite_region;
    private String superficie;
    private String langue_majoritaire;

    //définition d'une rélation pusieurs-à-un entre region et pays
    //Beaucoup de region peut etre associé à un seule objet de la classe pays
    @ManyToOne
    private Pays pays;
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    List<Population> populations=new ArrayList<>();

}
