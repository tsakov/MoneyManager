package lu.uni2013.tp4.jsf.converter.helper;

import lu.uni2013.tp2.ejb.entity.helper.AbstractDBObject;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * User: schullto
 * Date: 11/22/13
 * Time: 9:20 AM
 */
public abstract class AbstractDbObjectConverter implements Converter {
    @PersistenceContext
    private EntityManager em;
    @Inject
    private transient Logger log;

    public abstract Class getEntityClass();

    public Object getAsObject(FacesContext facesContext, UIComponent component, String id) {
        try {
            Object obj = em.find(getEntityClass(), Long.parseLong(id));
            return obj;
        } catch (IllegalArgumentException ignored) {
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object obj) {
        if (obj == null) return null;
        if (obj instanceof String && ((String) obj).trim().length() == 0) return null;
        if (obj instanceof AbstractDBObject) {
            return ((AbstractDBObject) obj).getId().toString();
        }
        return null;
    }
}