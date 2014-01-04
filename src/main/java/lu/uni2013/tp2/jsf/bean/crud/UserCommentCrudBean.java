package lu.uni2013.tp2.jsf.bean.crud;

import lu.uni2013.tp2.ejb.facades.UserCommentFacade;
import lu.uni2013.tp2.ejb.facades.helper.AbstractDBObjectFacade;
import lu.uni2013.tp2.jsf.bean.crud.helper.AbstractDBObjectCrudBean;
import lu.uni2013.tp4.ejb.entity.UserComment;
import lu.uni2013.tp4.jsf.bean.model.SessionData;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * User: schullto
 */
@Named
@ConversationScoped
public class UserCommentCrudBean extends AbstractDBObjectCrudBean<UserComment> {
    @Inject
    private Conversation conversation;
    @Inject
    private UserCommentFacade facade;
    @Inject
    private SessionData sessionData;

    @Override
    public Class getClazz() {
        return UserComment.class;
    }

    @Override
    public Conversation getConversation() {
        return conversation;
    }

    @Override
    public AbstractDBObjectFacade getFacade() {
        return facade;
    }

    @Override
    public String startNewEntity() {
        super.startNewEntity();
        editEntity.setUser(sessionData.getLoggedUser());
        return null;
    }
}