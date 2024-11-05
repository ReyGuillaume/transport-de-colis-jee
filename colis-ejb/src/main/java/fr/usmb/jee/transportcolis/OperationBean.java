package fr.usmb.jee.transportcolis;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@DataSourceDefinition(
        name = "java:app/env/jdbc/MyDataSource",
        className = "org.postgresql.ds.PGPoolingDataSource",
        user = "admin",
        password = "admin",
        portNumber = 5432,
        databaseName = "transportcolis"
)

@Stateless
@Remote
public class OperationBean implements Operation {
    @PersistenceContext(unitName = "transportcolis")
    private EntityManager em;

    public OperationBean() {
        super();
    }

    @Override
    public Colis enregistrerColis(
            String id,
            double poids,
            double valeur,
            String origine,
            String destination,
            String latitude,
            String longitude,
            String emplacement,
            String etat
    ) {
        Colis colis = new Colis(id, poids, valeur, origine, destination, latitude, longitude, emplacement, etat);
        em.persist(colis);
        return colis;
    }

    @Override
    public Colis getColis(String id) {
        return em.find(Colis.class, id);
    }

    @Override
    public Colis updatePosition(String id, String latitude, String longitude, String emplacement, String etat) {
        Colis colis = em.find(Colis.class, id);

        colis.setLatitude(latitude);
        colis.setLongitude(longitude);
        colis.setEmplacement(emplacement);
        colis.setEtat(etat);

        return colis;
    }
}
