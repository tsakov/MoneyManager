package lu.uni.moneymanager.jpa.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import lu.uni.moneymanager.jpa.entity.AbstractEntity;

public abstract class AbstractFacade implements Serializable {
    @PersistenceContext
    protected EntityManager em;

    public <T> T find(Class<T> clazz, Long id) {
        return em.find(clazz, id);
    }

    public void delete(AbstractEntity entity) {
        em.remove(entity);
    }

    public AbstractEntity saveOrUpdate(AbstractEntity entity) {
        return em.merge(entity);
    }
}
