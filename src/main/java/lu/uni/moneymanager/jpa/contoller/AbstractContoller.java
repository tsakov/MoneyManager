package lu.uni2013.tp2.jsf.bean.crud.helper;

import lu.uni2013.tp2.ejb.entity.helper.AbstractDBObject;
import lu.uni2013.tp2.ejb.facades.helper.AbstractDBObjectFacade;

import javax.enterprise.context.Conversation;
import java.io.Serializable;

public abstract class AbstractDBObjectCrudBean<T extends AbstractDBObject> implements Serializable {
    public abstract Class getClazz();

    public abstract Conversation getConversation();

    public abstract AbstractDBObjectFacade getFacade();

    protected T editEntity;
    protected T toDeleteEntity;

    public String startNewEntity() {
        if (getConversation().isTransient()) getConversation().begin();
        try {
            editEntity = (T) getClazz().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String startEditEntity(T editEntity) {
        if (getConversation().isTransient()) getConversation().begin();
        this.editEntity = editEntity;
        return null;
    }

    public String doSaveEdit() {
        editEntity = (T) getFacade().saveOrUpdate(editEntity);
        if (!getConversation().isTransient()) getConversation().end();
        return null;
    }

    public String startDelete(T editEntity) {
        if (getConversation().isTransient()) getConversation().begin();
        this.toDeleteEntity = editEntity;
        return null;
    }

    public String doDelete() {
        getFacade().delete(toDeleteEntity);
        toDeleteEntity = null;
        if (!getConversation().isTransient()) getConversation().end();
        return null;
    }

    public String doCancel() {
        if (!getConversation().isTransient()) getConversation().end();
        editEntity = null;
        toDeleteEntity = null;
        return null;
    }

    public T getEditEntity() {
        return editEntity;
    }

    public void setEditEntity(T editEntity) {
        this.editEntity = editEntity;
    }

    public T getToDeleteEntity() {
        return toDeleteEntity;
    }

    public void setToDeleteEntity(T toDeleteEntity) {
        this.toDeleteEntity = toDeleteEntity;
    }
}
