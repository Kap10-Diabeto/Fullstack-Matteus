/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.matsedel.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.te4.matsedel.beans.MealsBeans;
import nu.te4.matsedel.entities.Meals;

@Path("menu")
@Produces(MediaType.APPLICATION_JSON)
public class MenuResource {
    @EJB
    MealsBeans mealsBeans;
    
    
    @GET
    public Response ping(){
        Meals meal = mealsBeans.getMeal();
       return Response
               .ok(meal)
              .build();
    }
}
