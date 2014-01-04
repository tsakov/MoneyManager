package lu.uni2013.tp4.ws.rest;

import lu.uni2013.tp2.ejb.facades.UserCommentFacade;
import lu.uni2013.tp2.ejb.facades.UserFacade;
import lu.uni2013.tp4.ejb.entity.User;
import lu.uni2013.tp4.ejb.entity.UserComment;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

/**
 * User: schullto
 * Date: 11/21/13
 * Time: 6:47 PM
 */
@Path("/userComment")
public class UserCommentRestService {
    @Inject
    private UserFacade userFacade;
    @Inject
    private UserCommentFacade userCommentFacade;

    /*
    http://localhost:8080/tp4/rs/userComment/admin
    */

    @GET
    @Path("{userName}")
    @Produces(MediaType.APPLICATION_XML)
    public List<UserComment> getUserComments(@PathParam("userName") String userName) {
        User user = userFacade.findUserByUsername(userName);
        if (user != null) {
            return userCommentFacade.getAllForUser(user);
        }
        return Collections.emptyList();
    }
}