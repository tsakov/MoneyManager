package lu.uni2013.tp4.ws.rest;

import lu.uni2013.tp2.ejb.facades.UserFacade;
import lu.uni2013.tp4.ejb.entity.User;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * User: schullto
 * Date: 11/21/13
 * Time: 6:47 PM
 */
@Path("/user")
public class UserRestService {
    @Inject
    private UserFacade userFacade;


    /*
    http://localhost:8080/tp4/rs/user
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsers() {
        return userFacade.getAll();
    }

    /*
    http://localhost:8080/tp4/rs/user/count
     */
    @GET
    @Path("count")
    @Produces("text/plain")
    public int getUsersCount() {
        return userFacade.getAll().size();
    }
}