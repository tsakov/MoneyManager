package lu.uni2013.tp2.ejb.facades;

import lu.uni2013.tp2.ejb.facades.helper.AbstractDBObjectFacade;
import lu.uni2013.tp4.ejb.entity.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * User: schullto
 */
@Named
@Stateless
public class UserFacade extends AbstractDBObjectFacade {
    public List<User> getAll() {
        return em.createQuery("from User u where u.deleted is null").getResultList();
    }

    public User findUserByUsername(String username) {
        try {
            return (User) em.createQuery("from User u where u.username = :username and u.deleted is null")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException nrEx) {
            return null;
        }
    }
}