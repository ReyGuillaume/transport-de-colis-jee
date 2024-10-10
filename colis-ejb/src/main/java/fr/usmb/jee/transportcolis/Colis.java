package fr.usmb.jee.transportcolis;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Setter
@Getter
@Entity
public class Colis implements Serializable {
    @Id
    private String identifiant;
    private double poids;
    private double valeur;
    private String origine;
    private String destination;

    private String latitude;
    private String longitude;
    private String emplacement;
    private String etat;
    @Version
    private long version;

    public Colis() {
        super();
    }

    public Colis(
            String identifiant,
            double poids,
            double valeur,
            String origine,
            String destination,
            String latitude,
            String longitude,
            String emplacement,
            String etat
    ) {
        this.identifiant = identifiant;
        this.poids = poids;
        this.valeur = valeur;
        this.origine = origine;
        this.destination = destination;
        this.latitude = latitude;
        this.longitude = longitude;
        this.emplacement = emplacement;
        this.etat = etat;
    }
}
