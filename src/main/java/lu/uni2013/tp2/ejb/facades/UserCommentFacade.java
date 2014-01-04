package lu.uni2013.tp2.ejb.facades;

import lu.uni2013.tp2.ejb.facades.helper.AbstractDBObjectFacade;
import lu.uni2013.tp4.ejb.entity.User;
import lu.uni2013.tp4.ejb.entity.UserComment;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

/**
 * User: schullto
 */
@Named
@Stateless
public class UserCommentFacade extends AbstractDBObjectFacade {
    public List<UserComment> getAllForUser(User user) {
        return em.createQuery("from UserComment uc where uc.deleted is null and uc.user = :user").setParameter("user", user).getResultList();
    }
}