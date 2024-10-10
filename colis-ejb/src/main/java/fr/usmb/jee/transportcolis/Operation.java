package fr.usmb.jee.transportcolis;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("colis")
public interface Operation {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Colis enregistrerColis(
            @FormParam("identifiant") String id,
            @FormParam("poids") double poids,
            @FormParam("valeur") double valeur,
            @FormParam("origine") String origine,
            @FormParam("destination") String destination,
            @FormParam("latitude") String latitude,
            @FormParam("longitude") String longitude,
            @FormParam("emplacement") String emplacement,
            @FormParam("etat") String etat
    );

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Colis getColis(@PathParam("id") String numero);

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Colis updatePosition(
            @PathParam("id") String numero,
            @QueryParam("latitude") String latitude,
            @QueryParam("longitude") String longitude,
            @QueryParam("emplacement") String emplacement,
            @QueryParam("etat") String etat
    );
}