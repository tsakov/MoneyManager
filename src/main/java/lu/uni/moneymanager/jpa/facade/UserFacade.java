package lu.uni.moneymanager.jpa.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.util.List;
import lu.uni.moneymanager.jpa.entity.User;

@Named
@Stateless
public class UserFacade extends AbstractFacade {

    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    public User findUserByUsername(String username) {
        try {
            return (User) em.createQuery("SELECT u FROM User u where u.username = :username")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
