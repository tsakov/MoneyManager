package lu.uni2013.tp2.jsf.bean.crud;

import lu.uni2013.tp2.ejb.facades.UserFacade;
import lu.uni2013.tp2.ejb.facades.helper.AbstractDBObjectFacade;
import lu.uni2013.tp2.jsf.bean.crud.helper.AbstractDBObjectCrudBean;
import lu.uni2013.tp4.ejb.entity.User;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * User: schullto
 */
@Named
@ConversationScoped
public class UserCrudBean extends AbstractDBObjectCrudBean<User> {
    @Inject
    private Conversation conversation;
    @Inject
    private UserFacade facade;

    @Override
    public Class getClazz() {
        return User.class;
    }

    @Override
    public Conversation getConversation() {
        return conversation;
    }

    @Override
    public AbstractDBObjectFacade getFacade() {
        return facade;
    }
}