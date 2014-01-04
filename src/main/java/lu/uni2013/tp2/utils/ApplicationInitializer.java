package lu.uni2013.tp2.utils;

import lu.uni2013.tp4.ejb.entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

/**
 * User: schullto
 */
@Singleton
@Startup
public class ApplicationInitializer {
    @Inject
    private Logger log;
    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        log.info("init....");

        List<User> userList = em.createQuery("select object(u) from User u").getResultList();
        if (userList.size() == 0) {
            log.info("creating ADMIN-user...");
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword("admin1");
            adminUser.setAdminRole(true);
            em.merge(adminUser);
            log.info("ADMIN-user created.");
        }
    }
}
