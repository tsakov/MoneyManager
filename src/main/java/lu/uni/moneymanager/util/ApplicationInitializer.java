package lu.uni.moneymanager.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import lu.uni.moneymanager.jpa.entity.User;

@Singleton
@Startup
public class ApplicationInitializer {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        List<User> userList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        if (userList.isEmpty()) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword("admin");
            adminUser.setAdminRole(true);
            em.merge(adminUser);
        }
    }
}
