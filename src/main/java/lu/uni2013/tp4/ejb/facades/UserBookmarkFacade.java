package lu.uni2013.tp4.ejb.facades;

import lu.uni2013.tp2.ejb.facades.helper.AbstractDBObjectFacade;
import lu.uni2013.tp4.ejb.entity.User;
import lu.uni2013.tp4.ejb.entity.UserBookmark;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * User: schullto
 * Date: 11/22/13
 * Time: 12:44 PM
 */
@Named
@Stateless
public class UserBookmarkFacade extends AbstractDBObjectFacade {
    @Inject
    private java.util.logging.Logger log;

    public List<UserBookmark> getAllForUser(User user) {
        return em.createQuery("from UserBookmark ub where ub.deleted is null and ub.user = :user").setParameter("user", user).getResultList();
    }
}