package lu.uni2013.tp2.ejb.facades.helper;

import lu.uni2013.tp2.ejb.entity.helper.AbstractDBObject;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

/**
 * User: schullto
 */
public abstract class AbstractDBObjectFacade implements Serializable {
    @PersistenceContext
    protected EntityManager em;
    @Inject
    protected Logger log;

    public <T> T find(Class<T> clazz, Long id) {
        return em.find(clazz, id);
    }

    public void delete(AbstractDBObject dbObject) {
        dbObject.setDeleted(new Date());
        saveOrUpdate(dbObject);
    }

    public AbstractDBObject saveOrUpdate(AbstractDBObject dbObject) {
        return em.merge(dbObject);
    }
}
