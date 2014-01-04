package lu.uni.moneymanager.jpa.contoller;

import javax.enterprise.context.Conversation;
import java.io.Serializable;
import lu.uni.moneymanager.jpa.entity.AbstractEntity;
import lu.uni.moneymanager.jpa.facade.AbstractFacade;

public abstract class AbstractController<T extends AbstractEntity> implements Serializable {

    public abstract Class getClazz();

    public abstract Conversation getConversation();

    public abstract AbstractFacade getFacade();

    protected T editEntity;
    protected T toDeleteEntity;

    public String startNewEntity(String outcome) {
        if (getConversation().isTransient()) {
            getConversation().begin();
        }
        try {
            editEntity = (T) getClazz().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return outcome;
    }

    public String startEditEntity(T editEntity, String outcome) {
        if (getConversation().isTransient()) {
            getConversation().begin();
        }
        this.editEntity = editEntity;
        return outcome;
    }

    public String doSaveEdit(String outcome) {
        editEntity = (T) getFacade().saveOrUpdate(editEntity);
        if (!getConversation().isTransient()) {
            getConversation().end();
        }
        return outcome;
    }

    public String startDelete(T editEntity) {
        if (getConversation().isTransient()) {
            getConversation().begin();
        }
        this.toDeleteEntity = editEntity;
        return null;
    }

    public String doDelete() {
        getFacade().delete(toDeleteEntity);
        toDeleteEntity = null;
        if (!getConversation().isTransient()) {
            getConversation().end();
        }
        return null;
    }

    public String delete(T editEntity, String outcome) {
        startDelete(editEntity);
        doDelete();
        return outcome;
    }

    public String doCancel(String outcome) {
        if (!getConversation().isTransient()) {
            getConversation().end();
        }
        editEntity = null;
        toDeleteEntity = null;
        return outcome;
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
